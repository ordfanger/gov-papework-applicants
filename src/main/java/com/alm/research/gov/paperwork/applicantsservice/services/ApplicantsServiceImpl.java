package com.alm.research.gov.paperwork.applicantsservice.services;

import com.alm.research.gov.paperwork.applicantsservice.applicant.Applicant;
import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;
import com.alm.research.gov.paperwork.applicantsservice.repositories.ApplicantsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantsServiceImpl implements ApplicantsService {

    private final ApplicantsRepository applicantsRepository;
    private final ModelMapper modelMapper;

    @Override
    public Applicant createApplicant(ApplicantDTO applicantDTO) {
        Applicant applicant = modelMapper.map(applicantDTO, Applicant.class);
        return applicantsRepository.save(applicant);
    }
}
