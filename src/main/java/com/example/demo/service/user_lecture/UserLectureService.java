package com.example.demo.service.user_lecture;

import com.example.demo.controller.UserLectures.UserLecturesRequest;
import com.example.demo.exceptions.ForbiddenAccessException;

public interface UserLectureService{

    void assignUserToLecture(UserLecturesRequest request);

    void deleteUserFromLecture(UserLecturesRequest request) throws ForbiddenAccessException;

}
