package com.rob.workflow.service;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.repository.ApplicantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicantServiceImplTest {

    @Mock
    ApplicantRepository applicantRepository;

    @InjectMocks
    ApplicantServiceImpl applicantService;

    @Test
    public void getApplicants() throws Exception {
        when(applicantRepository.findAll()).thenReturn(new ArrayList<>());
        applicantService.getApplicants();
    }

    @Test
    public void getApplicant() throws Exception {
        when(applicantRepository.findOne(anyLong())).thenReturn(new Applicant());
        applicantService.getApplicant(1L);
    }

    @Test
    public void saveApplicant() throws Exception {
        when(applicantRepository.save(any(Applicant.class))).thenReturn(new Applicant());
        applicantService.saveApplicant(new Applicant());
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(applicantRepository).delete(any(Applicant.class));
        applicantService.delete(1L);

    }

}