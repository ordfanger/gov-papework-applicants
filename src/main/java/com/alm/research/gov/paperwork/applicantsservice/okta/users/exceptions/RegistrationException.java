package com.alm.research.gov.paperwork.applicantsservice.okta.users.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegistrationException extends IOException {
    private int code;
    private String error;

    public RegistrationException(int code, String error) {
        super(error);

        this.code = code;
        this.error = error;
    }
}
