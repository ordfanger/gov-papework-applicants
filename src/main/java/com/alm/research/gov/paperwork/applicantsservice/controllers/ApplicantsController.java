package com.alm.research.gov.paperwork.applicantsservice.controllers;

import com.alm.research.gov.paperwork.applicantsservice.applicant.Applicant;
import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;
import com.alm.research.gov.paperwork.applicantsservice.models.request.ApplicantRequestModel;
import com.alm.research.gov.paperwork.applicantsservice.models.response.ApplicantResponseModel;
import com.alm.research.gov.paperwork.applicantsservice.services.ApplicantsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class ApplicantsController {

    private final ApplicantsService applicantsService;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicantResponseModel> createApplicant(@Valid @RequestBody ApplicantRequestModel applicantRequestModel) throws IOException {
        ApplicantDTO applicantDTO = modelMapper.map(applicantRequestModel, ApplicantDTO.class);

        Applicant createdApplicant = applicantsService.createApplicant(applicantDTO);

        ApplicantResponseModel applicantResponseModel = modelMapper.map(createdApplicant, ApplicantResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(applicantResponseModel);
    }
}
