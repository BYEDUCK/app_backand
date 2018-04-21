package com.example.demo.service;

import com.example.demo.controller.Login.CreateLoginRequest;
import com.example.demo.controller.Login.LoginResponse;

public interface LoginService {

    LoginResponse register(CreateLoginRequest request);
}
