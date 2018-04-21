package com.example.demo.controller.Lectures;


import com.example.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/lectures")
public class LecturesController {

    private LectureService service;

    @Autowired
    public LecturesController(LectureService service){
        this.service = service;
    }

    @GetMapping(value = "/{lectureId}")
    public LectureResponse getLecture(@PathVariable("lectureId") int lectureId) {
       return service.findById(lectureId);
    }

    @GetMapping
    public List<LectureResponse> getAllLectures() {
        return service.findAll();
    }

    @PostMapping
    public LectureResponse create() {
        return service.save();
    }
}
