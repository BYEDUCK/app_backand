package com.example.demo.service;

import com.example.demo.controller.UserLectures.UserLecturesRequest;
import com.example.demo.entity.UserHasLectures;
import com.example.demo.exceptions.ForbiddenAccessException;
import com.example.demo.repository.UserLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLectureServiceImpl implements UserLectureService{

    private UserLectureRepository userLectureRepository;

    @Autowired
    public UserLectureServiceImpl(UserLectureRepository userLectureRepository){

        this.userLectureRepository = userLectureRepository;
    }

    @Override
    public void assignUserToLecture(UserLecturesRequest request) {
        UserHasLectures userLecture = new UserHasLectures();
        userLecture.getPrimaryKey().setLectureId(request.getLectureId());
        userLecture.getPrimaryKey().setUserId(request.getUserId());
        userLecture.setIsOwner(request.getIsOwner());
        userLectureRepository.save(userLecture);
    }

    @Override
    public void deleteUserFromLecture(UserLecturesRequest request) throws ForbiddenAccessException {

        int isOwner = request.getIsOwner();
        if(isOwner==1)
            throw new ForbiddenAccessException();
        else {
            UserHasLectures userLecture = new UserHasLectures();
            userLecture.getPrimaryKey().setUserId(request.getUserId());
            userLecture.getPrimaryKey().setLectureId(request.getLectureId());
            userLectureRepository.delete(userLecture);
        }
    }
}
