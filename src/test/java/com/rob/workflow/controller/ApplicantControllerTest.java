package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.service.ApplicantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicantControllerTest {

    @Mock
    ApplicantService applicantService;

    @InjectMocks
    ApplicantController applicantController;

    @Test
    public void saveApplicant() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(null, "test");
        Applicant applicant = new Applicant(1L, "test");
        when(applicantService.saveApplicant(any(Applicant.class))).thenReturn(applicant);
        ApplicantDto applicantDto1 = applicantController.saveApplicant(applicantDto);
        Long one = 1L;
        assertEquals(one, applicantDto1.getApplicantId());
    }

    @Test
    public void getApplicants() throws Exception {
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(new Applicant(1L, "test"));
        when(applicantService.getApplicants()).thenReturn(applicants);
        List<ApplicantDto> returnedApplicants = applicantController.getApplicants();
        assertEquals(1, returnedApplicants.size());
    }

    @Test
    public void updateApplicant() throws Exception {
    }

    @Test
    public void deleteApplicant() throws Exception {
        doNothing().when(applicantService).delete(anyLong());
        applicantService.delete(1L);
    }

}