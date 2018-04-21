package com.example.demo.controller.Questions;

import com.example.demo.entity.Lecture;
import com.example.demo.entity.Question;
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
    private int lectureId;
    private boolean isPublished;
    private LocalDateTime createdAt;


    public QuestionResponse(Question question) {
        id = question.getId();
        content = question.getContent();
        lectureId = question.getLecture().getId();
        createdAt = question.getCreatedAt();
    }
}
