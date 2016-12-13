package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import com.rob.workflow.repository.ApplicantRepository;
import com.rob.workflow.repository.ApplicationRepository;
import com.rob.workflow.repository.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ApplicantRepository applicantRepository;

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    ApplicationService applicationService = new ApplicationServiceImpl();

    @Test
    public void testCreate(){
        Job job = new Job(1L, "test");
        Applicant applicant = new Applicant(1L, "test");
        Application applicationIn = new Application("test", job, applicant, "test");

        when(jobRepository.findOne(job.getJobId())).thenReturn(job);
        Application application1 = applicationService.createApplication(applicationIn);



    }

}