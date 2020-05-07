package com.alm.research.gov.paperwork.applicantsservice.models.request;

import com.alm.research.gov.paperwork.applicantsservice.applicant.Address;
import com.alm.research.gov.paperwork.applicantsservice.applicant.Identity;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ApplicantRequestModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Valid
    private Address address;

    @NotNull
    @Valid
    private Identity identity;
}
