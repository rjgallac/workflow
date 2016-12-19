package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService{

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> getApplicants() {
        return (List<Applicant>) applicantRepository.findAll();
    }

    @Override
    public Optional<Applicant> getApplicant(Long id) {
        return Optional.of(applicantRepository.findOne(id));
    }

    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    public void delete(long id) {
        applicantRepository.delete(id);
    }
}
