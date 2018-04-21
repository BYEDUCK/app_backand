package com.example.demo.controller.Questions;

import com.example.demo.controller.Answer.AnswerResponse;
import com.example.demo.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponse {

    private int id;
    private String content;
    private int lectureId;
    private int isPublished;
    private LocalDateTime createdAt;
    private List<AnswerResponse> answers;


    public QuestionResponse(Question question) {
        id = question.getId();
        content = question.getContent();
        lectureId = question.getLecture().getId();
        createdAt = question.getCreatedAt();
        isPublished = question.getIsPublished();
        answers = question.getAnswers().stream().map(AnswerResponse::new).collect(Collectors.toList());
    }
}
