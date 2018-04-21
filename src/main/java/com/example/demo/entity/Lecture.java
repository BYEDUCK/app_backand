package com.example.demo.entity;

import com.example.demo.controller.Lectures.Day;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Column(name = "day")
    private Day day;

    @Column(name = "startHour")
    private Time starHour;

    @Column(name = "finishHour")
    private Time finishHour;

    @OneToMany(mappedBy = "lecture")
    private List<Question> questionList = new ArrayList<>();

}
