package com.example.demo.service;

import com.example.demo.controller.Lectures.LectureResponse;
import com.example.demo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface LectureService {

    LectureResponse findById(int id) throws ObjectNotFoundException;

    List<LectureResponse> findAll();

    LectureResponse save();


}
