package com.example.demo.controller.Lectures;

import com.example.demo.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LectureResponse {

    private int id;
    private String abbreviation;

}
