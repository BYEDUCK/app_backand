package com.example.demo.service.login;

import com.example.demo.controller.Login.CreateLoginRequest;
import com.example.demo.controller.Login.LoginResponse;
import com.example.demo.exceptions.ObjectNotFoundException;

public interface LoginService {

    LoginResponse login(CreateLoginRequest request) throws ObjectNotFoundException;

}
