package com.example.demo.service.user_lecture;

import com.example.demo.controller.UserLectures.UserLecturesRequest;
import com.example.demo.entity.UserHasLecturePrimaryKey;
import com.example.demo.entity.UserHasLectures;
import com.example.demo.exceptions.ForbiddenAccessException;
import com.example.demo.repository.UserLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLectureServiceImpl implements UserLectureService {

    private UserLectureRepository userLectureRepository;

    @Autowired
    public UserLectureServiceImpl(UserLectureRepository userLectureRepository) {

        this.userLectureRepository = userLectureRepository;
    }

    @Override
    public void assignUserToLecture(UserLecturesRequest request) {
        UserHasLectures userLecture = new UserHasLectures();
        userLecture.setPrimaryKey(new UserHasLecturePrimaryKey(
                request.getUserId(),
                request.getLectureId()
        ));
        userLecture.setIsOwner(request.getIsOwner());
        userLectureRepository.save(userLecture);
    }

    @Override
    public void deleteUserFromLecture(UserLecturesRequest request) throws ForbiddenAccessException {

        int isOwner = request.getIsOwner();
        if (isOwner == 1)
            throw new ForbiddenAccessException();

        UserHasLecturePrimaryKey primaryKey = new UserHasLecturePrimaryKey(
                request.getUserId(),
                request.getLectureId()
        );
        userLectureRepository.delete(primaryKey);
    }
}
