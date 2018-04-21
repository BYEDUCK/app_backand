package com.example.demo.service;

import com.example.demo.controller.UserLectures.UserLecturesRequest;
import com.example.demo.entity.UserHasLectures;
import com.example.demo.repository.LecturesRepository;
import com.example.demo.repository.UserLectureRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLectureServiceImpl implements UserLectureService{

    private UsersRepository usersRepository;
    private LecturesRepository lecturesRepository;
    private UserLectureRepository userLectureRepository;

    @Autowired
    public UserLectureServiceImpl(UsersRepository usersRepository,
                                  LecturesRepository lecturesRepository,
                                  UserLectureRepository userLectureRepository){

        this.usersRepository = usersRepository;
        this.lecturesRepository = lecturesRepository;
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
}
