package com.example.demo.controller.Questions;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateAnswerDTO {

    private String text;
    private int order;

    public Answer toAnswer(Question question) {
        Answer answer = new Answer();
        answer.setContent(this.text);
        answer.setOrder(this.order);
        answer.setQuestion(question);
        return answer;
    }

}
