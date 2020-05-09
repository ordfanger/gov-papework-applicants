package com.alm.research.gov.paperwork.applicantsservice.models.request;

import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Address;
import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Identity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantUpdateRequestModel {
    private Address address;
    private Identity identity;
}