package com.example.demo.controller.registration;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String email;
    private String password;
    private String name;

    public User toUser() {
        User user = new User();
        user.setEmail(getEmail());
        user.setName(getName());
        user.setPassword(getPassword());
        return user;
    }
}
