package com.example.demo.service;

import com.example.demo.controller.Lectures.LectureResponse;

import java.util.List;

public interface LectureService {

    LectureResponse findById(int id);

    List<LectureResponse> findAll();

    LectureResponse save();
}
