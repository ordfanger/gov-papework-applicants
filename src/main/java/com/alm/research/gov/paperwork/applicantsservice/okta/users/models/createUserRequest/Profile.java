package com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest;

import lombok.Data;

@Data
public class Profile {
    private String firstName;
    private String lastName;
    private String email;
    private String login;
}
