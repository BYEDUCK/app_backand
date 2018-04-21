package com.example.demo.repository;

import com.example.demo.entity.AnswerEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerEventRepository extends JpaRepository<AnswerEvent, Integer> {
    List<AnswerEvent> findByQuestion_Id(int questionId);
}
