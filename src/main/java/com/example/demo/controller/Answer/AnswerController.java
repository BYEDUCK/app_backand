package com.example.demo.controller.Answer;


import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @GetMapping(value = "/answers")
    public List<AnswerResponse> getAnswersForQuestion(@RequestParam("questionId") int questionId) {
        return service.findAllAnswersForQuestions(questionId);
    }

}
