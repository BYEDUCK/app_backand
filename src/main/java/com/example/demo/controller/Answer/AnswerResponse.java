package com.example.demo.controller.Answer;

import com.example.demo.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class AnswerResponse {

    private int id;
    private int order;
    private String content;
    private int questionId;

    public AnswerResponse(Answer answer) {
        this.id = answer.getId();
        this.content = answer.getContent();
        this.order = answer.getOrder();
        this.questionId = answer.getQuestion().getId();
    }
}
