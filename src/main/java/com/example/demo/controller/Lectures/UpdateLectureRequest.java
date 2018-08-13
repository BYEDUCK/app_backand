package com.example.demo.controller.Lectures;

import com.example.demo.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLectureRequest {
    private Integer id;
    private String name;
    private Day day;
    private String startHour;
    private String finishHour;

    public Lecture toLecture() {
        Lecture lecture = new Lecture();
        lecture.setId(id);
        lecture.setName(name);
        lecture.setDay(day);
        lecture.setStarHour(startHour);
        lecture.setFinishHour(finishHour);
        return lecture;
    }
}
