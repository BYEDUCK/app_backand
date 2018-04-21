package com.example.demo.entity;

import com.example.demo.controller.Lectures.Day;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
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
    private Integer starHour;

    @Column(name = "finishHour")
    private Integer finishHour;

    @OneToMany(mappedBy = "lecture")
    private List<Question> questionList = new ArrayList<>();

}
