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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Transactional
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
        ApplicantDto applicantDto = new ApplicantDto(1L, "test");
        JobDto jobDto = new JobDto(1L, "test");
        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDto, jobDto, "", "", null);
        Application application = new Application(1L, "test", new Job(1L, "test"), new Applicant(1L, "test"), "test");
        when(applicationService.getApplication(anyLong())).thenReturn(application);
        when(applicationService.save(any(Application.class))).thenReturn(application);
        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = applicationController.updateApplication(applicationDto, 1L);
        assertEquals("test", applicationDtoResponseEntity.getBody().getName());
    }

    @Test
    public void updateApplicationAccept() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(1L, "test");
        JobDto jobDto = new JobDto(1L, "test");
        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDto, jobDto, "com.rob.workflow.model.shortworkflow.StartState", "", null);
        applicationDto.setUpdateAction("accept");
        Application application = new Application(1L, "test", new Job(1L, "test"), new Applicant(1L, "test"), "com.rob.workflow.model.shortworkflow.StartState");
        when(applicationService.getApplication(anyLong())).thenReturn(application);
        when(applicationService.save(any(Application.class))).thenReturn(application);
        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = applicationController.updateApplication(applicationDto, 1L);
        assertEquals("test", applicationDtoResponseEntity.getBody().getName());
    }
    @Test
    public void updateApplicationReject() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(1L, "test");
        JobDto jobDto = new JobDto(1L, "test");
        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDto, jobDto, "com.rob.workflow.model.shortworkflow.StartState", "", null);
        applicationDto.setUpdateAction("reject");
        Application application = new Application(1L, "test", new Job(1L, "test"), new Applicant(1L, "test"), "com.rob.workflow.model.shortworkflow.StartState");
        when(applicationService.getApplication(anyLong())).thenReturn(application);
        when(applicationService.save(any(Application.class))).thenReturn(application);
        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = applicationController.updateApplication(applicationDto, 1L);
        assertEquals("test", applicationDtoResponseEntity.getBody().getName());
    }
    @Test
    public void updateApplicationWithdraw() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(1L, "test");
        JobDto jobDto = new JobDto(1L, "test");
        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDto, jobDto, "com.rob.workflow.model.shortworkflow.StartState", "", null);
        applicationDto.setUpdateAction("withdraw");
        Application application = new Application(1L, "test", new Job(1L, "test"), new Applicant(1L, "test"), "com.rob.workflow.model.shortworkflow.StartState");
        when(applicationService.getApplication(anyLong())).thenReturn(application);
        when(applicationService.save(any(Application.class))).thenReturn(application);
        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = applicationController.updateApplication(applicationDto, 1L);
        assertEquals("test", applicationDtoResponseEntity.getBody().getName());
    }

    @Test
    public void deleteApplication() throws Exception {
        applicationController.deleteApplication(1L);
    }

}