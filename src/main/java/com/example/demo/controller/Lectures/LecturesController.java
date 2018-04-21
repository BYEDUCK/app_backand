package com.example.demo.controller.Lectures;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LecturesController {

    private LectureService service;

    @Autowired
    public LecturesController(LectureService service){
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
    public LectureResponse create() {
        return service.save();
    }


}
