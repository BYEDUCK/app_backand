package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "is_correct")
    private int isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<AnswerEvent> answerEvent;

}
