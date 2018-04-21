package com.example.demo.service;

import com.example.demo.controller.Questions.QuestionResponse;

import java.time.LocalDateTime;

public interface QuestionService {


    //adding new Question
    QuestionResponse save();

    //getting questions by ID
    QuestionResponse findById(int id);

    //Getting all questions after time
    QuestionResponse findByIdAfterTime(int lectureId, LocalDateTime after);

}
