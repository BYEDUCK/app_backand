package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.event.ActionEvent;

@Entity
@Table(name = "answer")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "a_order")
    private int order;

    @Column(name = "content", length = 512)
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answer")
    private AnswerEvent answerEvent;

}
