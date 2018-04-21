package com.example.demo.controller.Lectures;


import com.example.demo.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
public class LectureResponse {

    private int id;
    private String abbreviation;
    private String name;
    private Day day;
    private LocalTime startDate;
    private LocalTime finishDate;

    public LectureResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.abbreviation = lecture.getAbbreviation();
        this.name = lecture.getName();
        this.day = lecture.getDay();
        this.startDate = lecture.getStarHour();
        this.finishDate = lecture.getFinishHour();
    }

}
