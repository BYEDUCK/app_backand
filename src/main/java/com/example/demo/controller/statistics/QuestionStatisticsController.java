package com.example.demo.controller.statistics;

import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.statistics.QuestionStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionStatisticsController {

    private QuestionStatisticsService service;

    @Autowired
    public QuestionStatisticsController(QuestionStatisticsService service) {
        this.service = service;
    }

    @GetMapping(value = "/questions/{questionId}/statistics")
    public QuestionStatisticsResponse getQuestionStatistics(@PathVariable("questionId") int questionId) throws ObjectNotFoundException {
        return service.getStats(questionId);
    }


}
