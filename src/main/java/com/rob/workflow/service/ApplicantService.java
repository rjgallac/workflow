package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;

import java.util.List;
import java.util.Optional;

interface  ApplicantService {

    List<Applicant> getApplicants();
    Optional<Applicant> getApplicant(Long id);
    Applicant saveApplicant(Applicant applicant);
    void delete(long id);
}
