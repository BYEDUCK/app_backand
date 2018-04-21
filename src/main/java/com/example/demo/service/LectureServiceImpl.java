package com.example.demo.service;

import com.example.demo.controller.Lectures.LectureResponse;
import com.example.demo.entity.Lecture;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repository.LecturesRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureServiceImpl implements LectureService {

    private LecturesRepository lecturesRepository;

    @Autowired
    public LectureServiceImpl(LecturesRepository lecturesRepository) {
        this.lecturesRepository = lecturesRepository;
    }

    @Override
    public LectureResponse findById(int id) throws ObjectNotFoundException {
        Lecture lecture = lecturesRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new LectureResponse(lecture);
    }

    @Override
    public List<LectureResponse> findAll() {
        return lecturesRepository.findAll()
                .stream()
                .map(lecture -> new LectureResponse(lecture))
                .collect(Collectors.toList());
    }

    @Override
    public LectureResponse save() {
        Lecture lecture = new Lecture();
        lecture.setAbbreviation(RandomStringUtils.randomAlphanumeric(6));
        lecture = lecturesRepository.save(lecture);
        return new LectureResponse(lecture);
    }
}
