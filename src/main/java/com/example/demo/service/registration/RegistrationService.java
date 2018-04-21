package com.example.demo.service.registration;

import com.example.demo.controller.registration.RegistrationRequest;
import com.example.demo.controller.registration.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse register(RegistrationRequest request) throws UserExistsException;
}
