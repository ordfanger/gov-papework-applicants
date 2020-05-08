package com.alm.research.gov.paperwork.applicantsservice.okta.users.models.createUserRequest;

import lombok.Data;

@Data
public class CreateUserRequest {
    private Profile profile;
    private Credentials credentials;
}

