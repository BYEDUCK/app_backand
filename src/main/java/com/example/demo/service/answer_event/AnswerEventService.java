package com.example.demo.service.answer_event;

import com.example.demo.controller.AnswerEvent.AnswerEventRequest;
import com.example.demo.controller.AnswerEvent.AnswerEventResponse;
import com.example.demo.exceptions.ObjectNotFoundException;

public interface AnswerEventService {

    AnswerEventResponse save(AnswerEventRequest request) throws ObjectNotFoundException;

}
