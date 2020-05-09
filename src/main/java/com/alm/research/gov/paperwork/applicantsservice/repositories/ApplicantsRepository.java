package com.alm.research.gov.paperwork.applicantsservice.repositories;

import com.alm.research.gov.paperwork.applicantsservice.models.applicant.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantsRepository extends MongoRepository<Applicant, String> {}
