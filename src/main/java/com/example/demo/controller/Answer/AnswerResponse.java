package com.example.demo.controller.Answer;

import com.example.demo.entity.Question;
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
}
