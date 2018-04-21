package com.example.demo.service;

import com.example.demo.controller.Questions.CreateAnswerDTO;
import com.example.demo.controller.Questions.CreateQuestionRequest;
import com.example.demo.controller.Questions.QuestionResponse;
import com.example.demo.controller.Questions.UpdateQuestionRequest;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository,
                               AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public QuestionResponse save(CreateQuestionRequest request) {
        Question question = createQuestionFromRequest(request);
        question = saveAnswers(request.getAnswers(), questionRepository.save(question));
        return new QuestionResponse(question);
    }

    @Override
    public QuestionResponse update(UpdateQuestionRequest request) throws ObjectNotFoundException {
        Question question = questionRepository.findById(request.getId()).orElseThrow(ObjectNotFoundException::new);
        question.setContent(request.getText());
        answerRepository.delete(question.getAnswers());
        questionRepository.save(question);
        saveAnswers(request.getAnswers(), question);
        return new QuestionResponse(question);
    }

    private Question createQuestionFromRequest(CreateQuestionRequest request) {
        Question question = new Question();
        question.setContent(request.getText());
        question.setPublished(request.isPublished());
        question.setCreatedAt(LocalDateTime.now());
        return question;
    }

    private Question saveAnswers(List<CreateAnswerDTO> answerDTOS, Question question) {
        List<Answer> answers = answerDTOS
                .stream()
                .map(createAnswerDTO -> createAnswerDTO.toAnswer(question))
                .map(answer -> answerRepository.save(answer))
                .collect(Collectors.toList());
        question.setAnswers(answers);
        return questionRepository.save(question);
    }

    @Override
    public QuestionResponse findById(int id) throws ObjectNotFoundException {

        Question question = questionRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new QuestionResponse(question);
    }

    @Override
    public List<QuestionResponse> findByLectureIdAfterTime(int lectureId, LocalDateTime after, boolean published) throws ObjectNotFoundException {
        return questionRepository.findByLecture_IdAndCreatedAtAfter(lectureId, after)
                .stream()
                .filter(question -> question.isPublished() == published)
                .map(QuestionResponse::new)
                .sorted((Comparator.comparing(QuestionResponse::getCreatedAt)))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        questionRepository.delete(id);
    }

    @Override
    public void publish(int questionId) throws ObjectNotFoundException {
        Question question = questionRepository.findById(questionId).orElseThrow(ObjectNotFoundException::new);
        question.setPublished(true);
        questionRepository.save(question);
    }
}
