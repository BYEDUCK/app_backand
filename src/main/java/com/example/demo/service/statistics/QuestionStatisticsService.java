package com.example.demo.service.statistics;

import com.example.demo.controller.statistics.QuestionStatisticsResponse;
import com.example.demo.exceptions.ObjectNotFoundException;

public interface QuestionStatisticsService {

    QuestionStatisticsResponse getStats(int questionId) throws ObjectNotFoundException;

}
