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
public class RegistrationResponse {
    private String name;
    private int id;
    private String email;

    public RegistrationResponse(User user) {
        name = user.getName();
        id = user.getId();
        email = user.getEmail();
    }
}
