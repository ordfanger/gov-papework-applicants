package com.alm.research.gov.paperwork.applicantsservice.okta.users.models.oktaCreatedUserResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OktaUserCreatedResponse {
    private String id;
    private String status;
    private Date created;
    private Date lastUpdated;
    private Date activated;
}