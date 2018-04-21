package com.example.demo.controller.Questions;


import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController(value = "/questions")
public class QuestionController {

    private QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(value = "/{questionId}")
    public QuestionResponse getQuestion(@PathVariable("questionId") int questionId) {
        return service.findById(questionId);
    }

    @PostMapping
    public QuestionResponse create() {
        return service.save();
    }

    @GetMapping
    public QuestionResponse getQuestionsForLectureAfter(@RequestParam("lectureId") int lectureId,
                                                @RequestParam("after") LocalDateTime after) {
        if (after == null){
            after = LocalDateTime.of(2006,5,12,5,15);
        }
        return service.findByIdAfterTime(lectureId, after);
    }
}
