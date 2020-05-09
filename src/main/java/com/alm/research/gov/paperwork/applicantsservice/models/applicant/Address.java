package com.alm.research.gov.paperwork.applicantsservice.models.applicant;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Address {
    @NotBlank(message = "country is missing in request body.")
    private String country;

    @NotBlank(message = "city is missing in request body.")
    private String city;

    @NotBlank(message = "street is missing in request body.")
    private String street;

    @NotBlank(message = "postcode is missing in request body.")
    private String postcode;

    @NotBlank(message = "houseNumber is missing in request body.")
    private String houseNumber;
}