package com.example.demo.service.login;

import com.example.demo.controller.Login.CreateLoginRequest;
import com.example.demo.controller.Login.LoginResponse;
import com.example.demo.entity.User;

public interface LoginService {

    LoginResponse login(CreateLoginRequest request);

    private boolean checkPassword(User user);
}
