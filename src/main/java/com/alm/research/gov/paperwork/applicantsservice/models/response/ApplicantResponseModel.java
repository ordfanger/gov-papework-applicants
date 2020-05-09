package com.alm.research.gov.paperwork.applicantsservice.models.response;

import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Address;
import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class ApplicantResponseModel {
    private String id;
    private Address address;
    private Identity identity;
    private Date registered_at;
}
