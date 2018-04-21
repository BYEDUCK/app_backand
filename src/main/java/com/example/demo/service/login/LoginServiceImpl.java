package com.example.demo.service.login;

import com.example.demo.controller.Login.CreateLoginRequest;
import com.example.demo.controller.Login.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.exceptions.ObjectNotFoundException;
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
    public LoginResponse login(CreateLoginRequest request) throws ObjectNotFoundException {
        User user = usersRepository.findByEmail(request.getEmail()).orElseThrow(ObjectNotFoundException::new);
        if (user.getPassword().equals(request.getPassword()))
            return new LoginResponse(user.getId());
        else
            throw new ObjectNotFoundException();
    }
}
