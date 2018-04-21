package com.example.demo.controller.Login;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class CreateLoginRequest {

    private String email;
    private String password;

}
