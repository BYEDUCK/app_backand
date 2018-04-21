package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserHasLecturePrimaryKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "lecture_id")
    private int lectureId;

}
