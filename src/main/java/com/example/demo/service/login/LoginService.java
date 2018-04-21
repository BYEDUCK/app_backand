package com.example.demo.service.login;

import com.example.demo.controller.Login.LoginRequest;
import com.example.demo.controller.Login.LoginResponse;
import com.example.demo.exceptions.UnathorizedException;

public interface LoginService {

    LoginResponse login(LoginRequest request) throws UnathorizedException;

}
