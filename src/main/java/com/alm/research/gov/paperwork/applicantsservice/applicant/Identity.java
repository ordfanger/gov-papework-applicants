package com.alm.research.gov.paperwork.applicantsservice.applicant;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class Identity {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String passportNumber;

    @NotEmpty
    private String phoneNumber;

    @Indexed(unique = true)
    @Email
    private String email;
}