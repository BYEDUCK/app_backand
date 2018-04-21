package com.example.demo.service;

import com.example.demo.controller.AnswerEvent.AnswerEventRequest;
import com.example.demo.entity.Answer;
import com.example.demo.entity.AnswerEvent;
import com.example.demo.entity.Question;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repository.AnswerEventRepository;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerEventServiceImpl implements AnswerEventService {


    private AnswerEventRepository answerEventRepository;
    private  AnswerRepository answerRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public AnswerEventServiceImpl(AnswerEventRepository answerEventRepository,
                                  AnswerRepository answerRepository, QuestionRepository questionRepository){

        this.answerEventRepository = answerEventRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void save(AnswerEventRequest request) throws ObjectNotFoundException {
        AnswerEvent answerEvent = new AnswerEvent();
        Answer answer = answerRepository.findById(request.getAnswerId())
                .orElseThrow(ObjectNotFoundException::new);
        answerEvent.setAnswer(answer);
        Question question = answer.getQuestion();
        LocalDateTime timeNow = LocalDateTime.now();
        answerEvent.setAnswer(answer);
        answerEvent.setQuestion(question);
        answerEvent.setTime(timeNow);
        answerEventRepository.save(answerEvent);
    }
}
