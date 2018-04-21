package com.example.demo.controller.statistics;

import com.example.demo.entity.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class QuestionStatisticsResponse {
    private int id;
    private String text;
    private int answersCount;
    private int attendantsCount;
    private List<AnswerStatisticsResponse> answersStatistics;

    public QuestionStatisticsResponse(Question question) {
        id = question.getId();
        text = question.getContent();
        answersStatistics = question.getAnswers().stream().map(AnswerStatisticsResponse::new).collect(Collectors.toList());
    }

    public void incrementAnswersCount() {
        answersCount++;
    }

    public void incrementAnswer(int id) {
        answersStatistics.stream().forEach(answer -> {
            if (answer.getId() == id) {
                answer.increment();
            }
        });
    }

    public QuestionStatisticsResponse add(QuestionStatisticsResponse questionStatisticsResponse2) {
        this.answersCount = this.answersCount + questionStatisticsResponse2.answersCount;
        this.answersStatistics.forEach(answer -> {
            questionStatisticsResponse2.getAnswersStatistics().forEach(answer2 ->
            {
                if (answer2.getId() == answer.getId()) {
                    answer.setNumberOfAnswers(answer.getNumberOfAnswers() + answer2.getNumberOfAnswers());
                }
            });
        });
    }
}
