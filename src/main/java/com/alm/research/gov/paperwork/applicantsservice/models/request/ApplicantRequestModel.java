package com.alm.research.gov.paperwork.applicantsservice.models.request;

import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Address;
import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Identity;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ApplicantRequestModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "address is missing in request body.")
    @Valid
    private Address address;

    @NotNull(message = "identity is missing in request body.")
    @Valid
    private Identity identity;
}
