package com.example.demo.controller.Questions;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public QuestionResponse create(@RequestBody CreateQuestionRequest request) throws ObjectNotFoundException {
        return service.save(request);
    }

    @GetMapping(value = "/questions")
    public List<QuestionResponse> getQuestionsForLectureAfter(@RequestParam("lectureId") int lectureId,
                                                              @RequestParam(value = "after", required = false)
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime after,
                                                              @RequestParam("published") int published) throws ObjectNotFoundException {
        if (after == null) {
            after = LocalDateTime.of(2006, 5, 12, 5, 15);
        }
        return service.findByLectureIdAfterTime(lectureId, after, published);
    }

    @PutMapping(value = "/questions")
    public QuestionResponse edit(@RequestBody UpdateQuestionRequest request) throws ObjectNotFoundException {
        return service.update(request);
    }

    @DeleteMapping(value = "/questions/{questionId}")
    public void delete(@PathVariable("questionId") int questionId) {
        service.delete(questionId);
    }

    @PostMapping(value = "/questions/{questionId}/publish")
    public void publish(@PathVariable("questionId") int questionId) throws ObjectNotFoundException {
        service.publish(questionId);
    }
}
