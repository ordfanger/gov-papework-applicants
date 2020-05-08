package com.alm.research.gov.paperwork.applicantsservice.okta.users.exceptions.handlers;

import com.alm.research.gov.paperwork.applicantsservice.okta.users.exceptions.RegistrationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RegistrationExceptionHandler {
    @ExceptionHandler(value = {RegistrationException.class, IOException.class})
    public ResponseEntity<Object> handle(RegistrationException e) {
        return ResponseEntity
                .status(e.getCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getError());
    }
}
