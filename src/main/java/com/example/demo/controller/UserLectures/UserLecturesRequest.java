package com.example.demo.controller.UserLectures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLecturesRequest {

    private int userId;
    private int lectureId;
    private int isOwner;

}
