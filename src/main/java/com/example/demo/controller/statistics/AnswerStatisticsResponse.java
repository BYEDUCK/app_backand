package com.example.demo.controller.statistics;

import com.example.demo.entity.Answer;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AnswerStatisticsResponse {
    private int id;
    private String text;
    private int numberOfAnswers;
    private float percentOfAnswers;

    public AnswerStatisticsResponse(Answer answer) {
        id = answer.getId();
        text = answer.getContent();
    }

    public void increment() {
        numberOfAnswers++;
    }
}
