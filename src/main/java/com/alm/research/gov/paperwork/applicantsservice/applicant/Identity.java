package com.alm.research.gov.paperwork.applicantsservice.applicant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class Identity {
    @NotBlank(message = "firstName is missing in request body.")
    private String firstName;

    @NotBlank(message = "lastName is missing in request body.")
    private String lastName;

    @NotBlank(message = "surname is missing in request body.")
    private String surname;

    @NotBlank(message = "passportNumber is missing in request body.")
    private String passportNumber;

    @NotBlank(message = "phoneNumber is missing in request body.")
    private String phoneNumber;

    @Indexed(unique = true)
    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private String password;
}