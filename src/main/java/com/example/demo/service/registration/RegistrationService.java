package com.example.demo.service.registration;

import com.example.demo.controller.registration.RegistrationRequest;
import com.example.demo.controller.registration.RegistrationResponse;
import com.example.demo.exceptions.UserExistsException;

public interface RegistrationService {
    RegistrationResponse register(RegistrationRequest request) throws UserExistsException;
}
