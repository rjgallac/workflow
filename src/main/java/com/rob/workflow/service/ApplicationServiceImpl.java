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
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRepository jobRepository;

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
        return (Application) applicationRepository.findOne(id);
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }


}
