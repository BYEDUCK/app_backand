package com.example.demo.controller.registration;

import com.example.demo.service.registration.RegistrationService;
import com.example.demo.service.registration.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping(value = "/register")
    public RegistrationResponse register(@RequestBody RegistrationRequest request) throws UserExistsException {
        return service.register(request);
    }

}
