package com.example.demo.entity;

import com.example.demo.controller.Lectures.Day;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private Day day;

    @Column(name = "startHour")
    private String starHour;

    @Column(name = "finishHour")
    private String finishHour;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "lastUpdatedAt")
    private Timestamp lastUpdatedAt;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<UserHasLectures> studentsOnLecture = new ArrayList<>();

}
