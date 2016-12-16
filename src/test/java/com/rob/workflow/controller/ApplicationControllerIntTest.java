package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.JobDto;
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
public class ApplicationControllerIntTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void saveApplication() throws Exception {
        JobDto jobDto = new JobDto(null, "test");
        ResponseEntity<JobDto> jobDtoResponseEntity = this.restTemplate.postForEntity("/job/", jobDto, JobDto.class);

        ApplicantDto applicantDto = new ApplicantDto(null, "test");
        ResponseEntity<ApplicantDto> applicantDtoResponseEntity = this.restTemplate.postForEntity("/applicant/", applicantDto, ApplicantDto.class);

        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDtoResponseEntity.getBody(), jobDtoResponseEntity.getBody(), "asd", "sdf", null);

        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = this.restTemplate.postForEntity("/application/", applicationDto, ApplicationDto.class);
        assertEquals(HttpStatus.OK, applicationDtoResponseEntity.getStatusCode());
    }

    @Test
    public void saveApplicationAndRetreive() throws Exception {
        JobDto jobDto = new JobDto(null, "test");
        ResponseEntity<JobDto> jobDtoResponseEntity = this.restTemplate.postForEntity("/job/", jobDto, JobDto.class);

        ApplicantDto applicantDto = new ApplicantDto(null, "test");
        ResponseEntity<ApplicantDto> applicantDtoResponseEntity = this.restTemplate.postForEntity("/applicant/", applicantDto, ApplicantDto.class);

        ApplicationDto applicationDto = new ApplicationDto(1L, "test", applicantDtoResponseEntity.getBody(), jobDtoResponseEntity.getBody(), "asd", "sdf", null);

        ResponseEntity<ApplicationDto> applicationDtoResponseEntity = this.restTemplate.postForEntity("/application/", applicationDto, ApplicationDto.class);
        assertEquals(HttpStatus.OK, applicationDtoResponseEntity.getStatusCode());

        ResponseEntity<ApplicationDto[]> forEntity = this.restTemplate.getForEntity("/application/", ApplicationDto[].class);

        assertEquals(1, forEntity.getBody().length);


    }


}