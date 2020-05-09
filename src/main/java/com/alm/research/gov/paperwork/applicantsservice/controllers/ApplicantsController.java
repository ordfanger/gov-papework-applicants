package com.alm.research.gov.paperwork.applicantsservice.controllers;

import com.alm.research.gov.paperwork.applicantsservice.models.ApplicantDTO;
import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Applicant;
import com.alm.research.gov.paperwork.applicantsservice.models.request.ApplicantRequestModel;
import com.alm.research.gov.paperwork.applicantsservice.models.request.ApplicantUpdateRequestModel;
import com.alm.research.gov.paperwork.applicantsservice.models.response.ApplicantResponseModel;
import com.alm.research.gov.paperwork.applicantsservice.services.ApplicantsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Applicants API", description = "applicants management")
public class ApplicantsController {

    private final ApplicantsService applicantsService;
    private final ModelMapper modelMapper;

    @Operation(
            summary = "Register applicant",
            operationId = "register",
            parameters = {
                    @Parameter(name = "request", description = "applicant request model", required = true)
            }
    )
    @PostMapping(path = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicantResponseModel> createApplicant(@Valid @RequestBody ApplicantRequestModel applicantRequestModel) throws IOException {
        ApplicantDTO applicantDTO = modelMapper.map(applicantRequestModel, ApplicantDTO.class);

        Applicant createdApplicant = applicantsService.createApplicant(applicantDTO);

        ApplicantResponseModel applicantResponseModel = modelMapper.map(createdApplicant, ApplicantResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(applicantResponseModel);
    }

    @Operation(
            summary = "Get applicant by ID",
            parameters = {
                    @Parameter(name = "applicantId", description = "applicant id", required = true)
            }
    )
    @GetMapping(path = "/applicant/{applicantId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicantResponseModel> getApplicant(@PathVariable String applicantId) {
        Applicant applicant = applicantsService.getApplicantById(applicantId);

        ApplicantResponseModel applicantResponseModel = modelMapper.map(applicant, ApplicantResponseModel.class);

        return ResponseEntity.ok(applicantResponseModel);
    }

    @Operation(
            summary = "Update applicant",
            parameters = {
                    @Parameter(name = "applicantId", description = "applicant id", required = true)
            }
    )
    @PutMapping(path = "/applicant/{applicantId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicantResponseModel> updateApplicant(
            @PathVariable String applicantId,
            @Valid @RequestBody ApplicantUpdateRequestModel applicantUpdateRequestModel) {

        ApplicantDTO applicantDTO = modelMapper.map(applicantUpdateRequestModel, ApplicantDTO.class);

        Applicant applicant = applicantsService.updateApplicant(applicantId, applicantDTO);

        ApplicantResponseModel applicantResponseModel = modelMapper.map(applicant, ApplicantResponseModel.class);

        return ResponseEntity.ok(applicantResponseModel);
    }
}
