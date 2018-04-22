package com.example.demo.controller.AnswerEvent;

import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.service.answer_event.AnswerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerEventController {

    private AnswerEventService service;

    @Autowired
    public AnswerEventController(AnswerEventService service){
        this.service = service;
    }

    @PostMapping(value = "/answer_event")
    public void add(@RequestBody AnswerEventRequest request) throws ObjectNotFoundException {
        service.save(request);
    }

}
