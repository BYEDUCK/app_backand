package com.example.demo.service;

import com.example.demo.controller.Questions.CreateQuestionRequest;
import com.example.demo.controller.Questions.QuestionResponse;
import com.example.demo.controller.Questions.UpdateQuestionRequest;
import com.example.demo.exceptions.ObjectNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface QuestionService {


    //adding new Question
    QuestionResponse save(CreateQuestionRequest request);

    QuestionResponse update(UpdateQuestionRequest request) throws ObjectNotFoundException;

    //getting questions by ID
    QuestionResponse findById(int id) throws ObjectNotFoundException;

    //Getting all questions after time
    List<QuestionResponse> findByLectureIdAfterTime(int lectureId, LocalDateTime after) throws ObjectNotFoundException;

    void delete(int id);

    void publish(int questionId) throws ObjectNotFoundException;

}
