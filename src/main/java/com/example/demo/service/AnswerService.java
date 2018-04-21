package com.example.demo.service;

import com.example.demo.controller.Answer.AnswerResponse;

import java.util.List;

public interface AnswerService {

     List<AnswerResponse> findAllAnswersForQuestions(int questionId);

}
