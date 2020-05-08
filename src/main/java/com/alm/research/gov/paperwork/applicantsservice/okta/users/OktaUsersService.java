package com.alm.research.gov.paperwork.applicantsservice.okta.users;

import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;

import java.io.IOException;

public interface OktaUsersService {
    ApplicantDTO createUser(ApplicantDTO applicantDTO) throws IOException;
}
