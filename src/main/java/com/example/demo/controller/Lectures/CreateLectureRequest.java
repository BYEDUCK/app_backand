package com.example.demo.controller.Lectures;

import com.example.demo.entity.Lecture;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateLectureRequest {
    private String name;
    private Day day;
    private String startHour;
    private String finishHour;

    public Lecture toLecture() {
        Lecture lecture = new Lecture();
        lecture.setName(this.name);
        lecture.setDay(this.day);
        lecture.setStarHour(this.startHour);
        lecture.setFinishHour(this.finishHour);
        return lecture;
    }
}
