package com.example.demo.service;

import com.example.demo.controller.Answer.AnswerResponse;
import com.example.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {


    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<AnswerResponse> findAllAnswersForQuestions(int questionId) {
        return answerRepository.findByQuestion_Id(questionId)
                .stream()
                .map(AnswerResponse::new)
                .sorted(Comparator.comparingInt(AnswerResponse::getOrder))
                .collect(Collectors.toList());
    }
}
