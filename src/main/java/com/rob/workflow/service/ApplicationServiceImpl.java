package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import com.rob.workflow.repository.ApplicantRepository;
import com.rob.workflow.repository.ApplicationRepository;
import com.rob.workflow.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository applicationRepository;

    private final ApplicantRepository applicantRepository;

    private final JobRepository jobRepository;

    @Autowired
    ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
        this.jobRepository = jobRepository;
    }

    public Application createApplication(Application application){
        Job one = jobRepository.findOne(application.getJob().getJobId());
        Applicant one1 = applicantRepository.findOne(application.getApplicant().getApplicantId());
        application.setJob(one);
        application.setApplicant(one1);
        return applicationRepository.save(application);
    }

    public List<Application> getApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    public Application getApplication(Long id) {
        return applicationRepository.findOne(id);
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteOne(Long id){
        applicationRepository.delete(id);
    }
}
