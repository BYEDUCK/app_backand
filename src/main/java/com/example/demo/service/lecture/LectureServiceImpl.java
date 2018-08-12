package com.example.demo.service.lecture;

import com.example.demo.controller.Lectures.CreateLectureRequest;
import com.example.demo.controller.Lectures.LectureResponse;
import com.example.demo.entity.Lecture;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repository.LecturesRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(LectureResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public LectureResponse save(CreateLectureRequest request) {
        Lecture lecture = request.toLecture();
        lecture.setAbbreviation(RandomStringUtils.randomAlphanumeric(6));
        lecture = lecturesRepository.save(lecture);
        return new LectureResponse(lecture);
    }

    @Override
    public LectureResponse findByAbbreviation(String abbreviation) throws ObjectNotFoundException {
        Lecture lecture = lecturesRepository.findByAbbreviation(abbreviation).orElseThrow(ObjectNotFoundException::new);
        return new LectureResponse(lecture);
    }

    @Override
    public void deleteById(int id) throws ObjectNotFoundException {
        Lecture lecture = lecturesRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        lecturesRepository.delete(lecture);
    }
}
