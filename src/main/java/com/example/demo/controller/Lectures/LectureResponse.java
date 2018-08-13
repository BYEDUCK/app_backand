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
    private String name;
    private Day day;
    private String startHour;
    private String finishHour;
    private String createdAt;

    public LectureResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.abbreviation = lecture.getAbbreviation();
        this.name = lecture.getName();
        this.day = lecture.getDay();
        this.startHour = lecture.getStarHour();
        this.finishHour = lecture.getFinishHour();
        this.createdAt = lecture.getCreatedAt().toString();
    }

}
