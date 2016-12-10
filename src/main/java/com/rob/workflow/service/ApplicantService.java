package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> getApplicants() {
        return (List<Applicant>) applicantRepository.findAll();
    }

    public void saveApplicant(Applicant applicant){
        applicantRepository.save(applicant);
    }

    public void delete(long id) {
        applicantRepository.delete(id);
    }
}
