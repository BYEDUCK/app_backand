package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class UserHasLecturePrimaryKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "lecture_id")
    private int lectureId;

}
