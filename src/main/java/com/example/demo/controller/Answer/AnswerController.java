package com.example.demo.controller.Answer;


import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/answers")
public class AnswerController {

    AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @GetMapping
    public List<AnswerResponse> getAnswersForQuestionAfter (@RequestParam("questionId") int questionId) {
        return service.findAllAnswersForQuestions(questionId);
    }

}
