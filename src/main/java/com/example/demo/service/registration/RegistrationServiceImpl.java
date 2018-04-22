package com.example.demo.service.registration;

import com.example.demo.controller.registration.RegistrationRequest;
import com.example.demo.controller.registration.RegistrationResponse;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserExistsException;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegistrationServiceImpl implements RegistrationService {

    private UsersRepository usersRepository;

    @Autowired
    public RegistrationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public RegistrationResponse register(RegistrationRequest request) throws UserExistsException {
        Optional<User> user = usersRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new UserExistsException();
        }
        return new RegistrationResponse(usersRepository.save(request.toUser()));
    }
}
