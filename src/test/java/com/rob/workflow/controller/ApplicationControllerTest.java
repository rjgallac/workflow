package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerTest {

    @Mock
    ApplicationService applicationService;

    @InjectMocks
    ApplicationController applicationController;

    @Test
    public void saveApplication() throws Exception {
        JobDto jobDto = new JobDto(1L, "test");
        ApplicantDto applicantDto = new ApplicantDto(1L, "test");
        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDto, jobDto, "sdf", "startDate", null);
        Job job = new Job(1L, "test");
        Applicant applicant = new Applicant(1L, "test");
        when(applicationService.createApplication(any())).thenReturn(new Application(1L, "test", job, applicant, ""));
        applicationController.saveApplication(applicationDto);
    }

    @Test
    public void getApplications() throws Exception {

    }

    @Test
    public void updateApplications() throws Exception {

    }

    @Test
    public void deleteApplication() throws Exception {

    }

}