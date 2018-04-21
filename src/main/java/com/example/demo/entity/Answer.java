package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "order")
    private int order;

    @Column(name = "content", length = 512)
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
