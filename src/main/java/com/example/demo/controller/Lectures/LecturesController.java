package com.example.demo.controller.Lectures;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LecturesController {

    private LectureService service;

    @Autowired
    public LecturesController(LectureService service) {
        this.service = service;
    }

    @GetMapping(value = "/lectures/{lectureId}")
    public LectureResponse getLecture(@PathVariable("lectureId") int lectureId) throws ObjectNotFoundException {
        return service.findById(lectureId);
    }

    @GetMapping(value = "/lectures")
    public List<LectureResponse> getAllLectures() {
        return service.findAll();
    }

    @PostMapping(value = "/lectures")
    public LectureResponse create(@RequestBody CreateLectureRequest request) {
        return service.save(request);
    }

    @GetMapping(value = "/lectures/abrev/{lectureAbrev}")
    public LectureResponse getLectureByAbrev(@PathVariable("lectureAbrev") String lectureAbrev) throws ObjectNotFoundException {
        return service.findByAbbreviation(lectureAbrev);
    }

    @DeleteMapping(value = "/lectures/{lectureId}")
    public void deleteLecture(@PathVariable("lectureId") int lectureId) throws ObjectNotFoundException {
        service.deleteById(lectureId);
    }

}
