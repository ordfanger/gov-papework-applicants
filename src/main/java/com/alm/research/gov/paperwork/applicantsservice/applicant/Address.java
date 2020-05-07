package com.alm.research.gov.paperwork.applicantsservice.applicant;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class Address {
    @NotBlank
    private String country;

    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private String postcode;

    @NotEmpty
    private String houseNumber;
}