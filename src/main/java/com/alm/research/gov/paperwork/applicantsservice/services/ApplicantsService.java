package com.alm.research.gov.paperwork.applicantsservice.services;

import com.alm.research.gov.paperwork.applicantsservice.applicant.Applicant;
import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;

public interface ApplicantsService {
    Applicant createApplicant(ApplicantDTO applicantDTO);
}
