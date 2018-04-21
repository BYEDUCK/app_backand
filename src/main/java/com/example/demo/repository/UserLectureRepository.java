package com.example.demo.repository;

import com.example.demo.entity.UserHasLectures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLectureRepository extends JpaRepository<UserHasLectures, Integer> {
}
