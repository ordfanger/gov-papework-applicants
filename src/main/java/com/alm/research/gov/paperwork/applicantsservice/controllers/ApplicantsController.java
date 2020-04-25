package com.alm.research.gov.paperwork.applicantsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class ApplicantsController {

    @GetMapping("/ping")
    public String ping() {
        return "ok";
    }
}
