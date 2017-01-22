package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantAndApplicationsDto;
import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.service.ApplicantServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicantControllerTest {

    @Mock
    ApplicantServiceImpl applicantService;

    @InjectMocks
    ApplicantController applicantController;

    @Test
    public void saveApplicant() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(null, "test");
        Applicant applicant = new Applicant(1L, "test");
        when(applicantService.saveApplicant(any(Applicant.class))).thenReturn(applicant);
        ResponseEntity<ApplicantDto> applicantDto1 = applicantController.saveApplicant(applicantDto);
        Long one = 1L;
        assertEquals(one, applicantDto1.getBody().getApplicantId());
    }

    @Test
    public void getApplicants() throws Exception {
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(new Applicant(1L, "test"));
        when(applicantService.getApplicants()).thenReturn(applicants);
        ResponseEntity<List<ApplicantDto>> returnedApplicants = applicantController.getApplicant();
        assertEquals(1, returnedApplicants.getBody().size());
    }
    @Test
    public void getApplicant() throws Exception {
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(new Applicant(1L, "test"));
        when(applicantService.getApplicant(1L)).thenReturn(Optional.of(new Applicant(1L, "test")));
        ResponseEntity<ApplicantAndApplicationsDto> applicant = applicantController.getApplicant(1L);
        assertEquals(HttpStatus.OK, applicant.getStatusCode());
    }

    @Test
    public void getApplicantNotFound() throws Exception {
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(new Applicant(1L, "test"));
        when(applicantService.getApplicant(1L)).thenReturn(Optional.empty());
        ResponseEntity<ApplicantAndApplicationsDto> applicant = applicantController.getApplicant(1L);
        assertEquals(HttpStatus.NOT_FOUND, applicant.getStatusCode());
    }

    @Test
    public void updateApplicant() throws Exception {
        applicantController.updateApplicant(1L);
    }

    @Test
    public void deleteApplicant() throws Exception {
        doNothing().when(applicantService).delete(anyLong());
        applicantController.deleteApplicant(1L);
    }

}