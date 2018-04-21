package com.example.demo.controller.UserLectures;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLecturesController {

    @PostMapping(value = "user_lectures")
    public void assignUserToLecture(@RequestBody UserLecturesRequest request){

    }

}
