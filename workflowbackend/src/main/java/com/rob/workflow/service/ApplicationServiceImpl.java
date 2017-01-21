package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.ApplicationHistory;
import com.rob.workflow.model.Job;
import com.rob.workflow.repository.ApplicantRepository;
import com.rob.workflow.repository.ApplicationRepository;
import com.rob.workflow.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository applicationRepository;

    private final ApplicantRepository applicantRepository;

    private final JobRepository jobRepository;

    private final ApplicationHistoryService applicationHistoryService;

    @Autowired
    ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository, JobRepository jobRepository, ApplicationHistoryService applicationHistoryService) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
        this.jobRepository = jobRepository;
        this.applicationHistoryService = applicationHistoryService;
    }

    public Application createApplication(Application application){
        Job one = jobRepository.findOne(application.getJob().getJobId());

        Applicant one1 = applicantRepository.findOne(application.getApplicant().getApplicantId());
        application.setJob(one);
        application.setApplicant(one1);
        application.setWorkflowStateString(one.getApplicationStartState());
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

    public Application actionApplication(Application application, String updateAction){

        application.restoreState();
        if(updateAction != null){
            if(updateAction.equals("accept")) {
                application.next();
                ApplicationHistory accept = applicationHistoryService.addHistory(new ApplicationHistory("accept", LocalDateTime.now()));
                application.addHistory(accept);
            }
            if(updateAction.equals("reject")) {
                application.reject();
                ApplicationHistory reject = applicationHistoryService.addHistory(new ApplicationHistory("reject", LocalDateTime.now()));
                application.addHistory(reject);
            }
            if(updateAction.equals("withdraw")) {
                application.withdraw();
                ApplicationHistory withdraw = applicationHistoryService.addHistory(new ApplicationHistory("withdraw", LocalDateTime.now()));
                application.addHistory(withdraw);
            }
        }
        application.setStateString();
        applicationRepository.save(application);
        return application;
    }

    public void deleteOne(Long id){
        applicationRepository.delete(id);
    }
}
