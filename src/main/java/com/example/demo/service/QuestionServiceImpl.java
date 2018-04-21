package com.example.demo.service;

import com.example.demo.controller.Questions.CreateQuestionRequest;
import com.example.demo.controller.Questions.QuestionResponse;
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
        question = saveAnswers(request, questionRepository.save(question));
        return new QuestionResponse(question);
    }

    private Question createQuestionFromRequest(CreateQuestionRequest request) {
        Question question = new Question();
        question.setContent(request.getText());
        return question;
    }

    private Question saveAnswers(CreateQuestionRequest request, Question question) {
        List<Answer> answers = request.getAnswers()
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
        return new QuestionResponse(question.getId(), question.getContent(),
                question.getLecture().getId(), question.getCreatedAt());
    }

    @Override
    public List<QuestionResponse> findByLectureIdAfterTime(int lectureId, LocalDateTime after) throws ObjectNotFoundException {
        return questionRepository.findByLecture_IdAndCreatedAtAfter(lectureId, after)
                .stream()
                .map(QuestionResponse::new)
                .sorted((Comparator.comparing(QuestionResponse::getCreatedAt)))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        questionRepository.delete(id);
    }

}
