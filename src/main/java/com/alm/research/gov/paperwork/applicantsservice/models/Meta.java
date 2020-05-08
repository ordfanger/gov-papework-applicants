package com.alm.research.gov.paperwork.applicantsservice.models;

import com.alm.research.gov.paperwork.applicantsservice.okta.users.models.oktaCreatedUserResponse.OktaUserCreatedResponse;
import lombok.Data;

@Data
public class Meta {
    private OktaUserCreatedResponse oktaUser;
}
