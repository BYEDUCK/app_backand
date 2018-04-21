package com.example.demo.service.statistics;

import com.example.demo.controller.statistics.QuestionStatisticsResponse;
import com.example.demo.entity.AnswerEvent;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repository.AnswerEventRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

@Component
public class QuestionStatisticsServiceImpl implements QuestionStatisticsService {

    private final QuestionRepository questionRepository;
    private final AnswerEventRepository answerEventRepository;

    @Autowired
    public QuestionStatisticsServiceImpl(QuestionRepository questionRepository,
                                         AnswerEventRepository answerEventRepository) {
        this.questionRepository = questionRepository;
        this.answerEventRepository = answerEventRepository;
    }


    @Override
    public QuestionStatisticsResponse getStats(int questionId) throws ObjectNotFoundException {
        QuestionStatisticsResponse response = new QuestionStatisticsResponse(questionRepository.findById(questionId)
                .orElseThrow(ObjectNotFoundException::new));
        return answerEventRepository.findByQuestion_Id(questionId)
                .stream()
                .reduce(response, (questionStatisticsResponse, answerEvent) -> {
                    questionStatisticsResponse.incrementAnswersCount();
                    questionStatisticsResponse.incrementAnswer(answerEvent.getAnswer().getId());
                    return questionStatisticsResponse;
                }, QuestionStatisticsResponse::add);
    }


}
