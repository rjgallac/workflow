package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicantControllerIntTest {

    private TestRestTemplate restTemplate;

    @Autowired
    public ApplicantControllerIntTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void saveApplicant() throws Exception {
        ApplicantDto applicantDto = new ApplicantDto(null, "test");
        ResponseEntity<ApplicantDto> applicantDtoResponseEntity = this.restTemplate.postForEntity("/applicant/", applicantDto, ApplicantDto.class);
        assertEquals(HttpStatus.OK, applicantDtoResponseEntity.getStatusCode());
    }

}