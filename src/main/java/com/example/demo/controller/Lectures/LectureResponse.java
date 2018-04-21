package com.example.demo.controller.Lectures;


import com.example.demo.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class LectureResponse {

    private int id;
    private String abbreviation;
    private String name;
    private Day day;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public LectureResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.abbreviation = lecture.getAbbreviation();
        this.name = lecture.getName();
        this.day = lecture.getDay();
        this.startDate = lecture.getStarHour();
        this.finishDate = lecture.getFinishHour();
    }

}
