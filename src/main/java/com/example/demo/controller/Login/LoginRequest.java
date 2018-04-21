package com.example.demo.controller.Login;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class LoginRequest {

    private String email;
    private String password;

}
