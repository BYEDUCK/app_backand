package com.example.demo.controller.UserLectures;

import com.example.demo.exceptions.ForbiddenAccessException;
import com.example.demo.service.UserLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLecturesController {

    private UserLectureService service;

    @Autowired
    public UserLecturesController(UserLectureService service){

        this.service = service;
    }

    @PostMapping(value = "/user_lectures")
    public void assignUserToLecture(@RequestBody UserLecturesRequest request){
        service.assignUserToLecture(request);
    }

    @DeleteMapping(value = "user_lectures")
    public void removeUserFromLecture(@RequestBody UserLecturesRequest request) throws ForbiddenAccessException {
        service.deleteUserFromLecture(request);
    }

}
