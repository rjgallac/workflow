package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import org.flywaydb.core.Flyway;
import org.junit.Before;
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
public class JobControllerIntTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup(){
        flyway.clean();
        flyway.migrate();
    }


    @Test
    public void saveJob() throws Exception {
        JobDto jobDto = new JobDto(null, "test", null, null, "com.rob.workflow.model.shortworkflow.StartState");
        ResponseEntity<JobDto> jobDtoResponseEntity = this.restTemplate.postForEntity("/job/", jobDto, JobDto.class);
        assertEquals(HttpStatus.OK, jobDtoResponseEntity.getStatusCode());
    }

    @Test
    public void saveJobAndRetrieve() throws Exception {
        JobDto jobDto = new JobDto();
        ResponseEntity<JobDto> jobDtoResponseEntity = this.restTemplate.postForEntity("/job/", jobDto, JobDto.class);
        this.restTemplate.postForEntity("/job/", jobDto, JobDto.class);
        assertEquals(HttpStatus.OK, jobDtoResponseEntity.getStatusCode());
        ResponseEntity<JobDto[]> forEntity = this.restTemplate.getForEntity("/job/", JobDto[].class);
        assertEquals(2, forEntity.getBody().length);
    }


}