package com.example.demo.service.login;

import com.example.demo.controller.Login.LoginRequest;
import com.example.demo.controller.Login.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UnathorizedException;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UsersRepository usersRepository;


    @Autowired
    public LoginServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws UnathorizedException {
        User user = usersRepository.findByEmail(request.getEmail()).orElseThrow(UnathorizedException::new);
        if (user.getPassword().equals(request.getPassword()))
            return new LoginResponse(user.getId());
        else
            throw new UnathorizedException();
    }
}
