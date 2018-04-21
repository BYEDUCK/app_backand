package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_has_lectures")
public class UserHasLectures {

    @EmbeddedId
    private UserHasLecturePrimaryKey primaryKey;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id", insertable = false, updatable = false)
    private Lecture lecture;

    @Column(name = "is_owner")
    private int isOwner;

}
