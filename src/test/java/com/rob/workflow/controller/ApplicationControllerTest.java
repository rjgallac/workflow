package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.model.Application;
import com.rob.workflow.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerTest {

    @Mock
    ApplicationService applicationService;

    @InjectMocks
    ApplicationController applicationController;

    @Test
    public void saveApplication() throws Exception {
        ApplicationDto applicationDto = new ApplicationDto();
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