package com.example.demo.entity;

import com.example.demo.controller.Lectures.Day;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
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

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Column(name = "day")
    private Day day;

    @Column(name = "startHour")
    private LocalDateTime starHour;

    @Column(name = "finishHour")
    private LocalDateTime finishHour;

    @OneToMany(mappedBy = "lecture")
    private List<Question> questionList = new ArrayList<>();

}
