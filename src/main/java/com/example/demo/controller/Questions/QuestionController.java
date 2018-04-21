package com.example.demo.controller.Questions;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class QuestionController {

    private QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(value = "/questions/{questionId}")
    public QuestionResponse getQuestion(@PathVariable("questionId") int questionId) throws ObjectNotFoundException {
        return service.findById(questionId);
    }

    @PostMapping(value = "/questions")
    public QuestionResponse create(@RequestBody CreateQuestionRequest request) {
        return service.save(request);
    }

    @GetMapping(value = "/questions")
    public List<QuestionResponse> getQuestionsForLectureAfter(@RequestParam("lectureId") int lectureId,
                                                              @RequestParam("after") LocalDateTime after) throws ObjectNotFoundException {
        if (after == null){
            after = LocalDateTime.of(2006,5,12,5,15);
        }
        return service.findByLectureIdAfterTime(lectureId, after);
    }
}
