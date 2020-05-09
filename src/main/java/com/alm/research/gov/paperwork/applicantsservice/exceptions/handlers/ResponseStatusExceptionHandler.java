package com.alm.research.gov.paperwork.applicantsservice.exceptions.handlers;

import com.alm.research.gov.paperwork.applicantsservice.exceptions.DefaultError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseStatusExceptionHandler {

    @ExceptionHandler(value = { ResponseStatusException.class })
    public ResponseEntity<Object> responseStatusHandler(ResponseStatusException e) {
        return ResponseEntity
                .status(e.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new DefaultError(e.getReason(), new Date(), e.getStatus().value()));
    }

}
