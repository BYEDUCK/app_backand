package com.example.demo.controller.Questions;

import com.example.demo.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponse {

    private int id;
    private String content;
    private Lecture lecture;
    private LocalDateTime createdAt;


}
