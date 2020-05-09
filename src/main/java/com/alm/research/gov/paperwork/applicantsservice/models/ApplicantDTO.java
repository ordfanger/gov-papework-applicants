package com.alm.research.gov.paperwork.applicantsservice.models;

import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Address;
import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Identity;
import lombok.Data;

import java.util.Date;

@Data
public class ApplicantDTO {
    private String id;
    private Address address;
    private Identity identity;
    private Date registered_at;
    private Meta meta;
}
