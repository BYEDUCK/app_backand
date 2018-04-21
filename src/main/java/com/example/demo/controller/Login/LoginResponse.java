package com.example.demo.controller.Login;


import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class LoginResponse {

    private String email;
    private String password;

    public LoginResponse(User user) {

        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
