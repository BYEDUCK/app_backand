package com.example.demo.controller.Login;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public LoginResponse createAccount(@RequestBody CreateLoginRequest request) throws ObjectNotFoundException {
        return service.login(request);
    }


}
