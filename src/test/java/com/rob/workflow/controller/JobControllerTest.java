package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.JobServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JobControllerTest {

    @Mock
    JobServiceImpl jobService;

    @InjectMocks
    JobController jobController;
    @Test
    public void saveJob() throws Exception {
        Job test1 = new Job(1L, "test");
        when(jobService.saveJob(any(Job.class))).thenReturn(test1);
        ResponseEntity<JobDto> test = jobController.saveJob(new JobDto(1L, "test"));
        assertEquals("test", test.getBody().getName());
    }

    @Test
    public void getJobs() throws Exception {
        List<Job> jobsReturned = new ArrayList();
        jobsReturned.add(new Job(1L, "test"));
        when(jobService.getJobs()).thenReturn(jobsReturned);
        List<JobDto> jobs = jobController.getJobs();
        assertEquals(1, jobs.size());
    }
    @Test
    public void getJob() throws Exception {
        Job job = new Job(1L, "test");
        when(jobService.getJob(1L)).thenReturn(Optional.of(job));
        ResponseEntity<JobDto> job1 = jobController.getJob(1L);
        assertEquals("test", job1.getBody().getName());
    }

    @Test
    public void updateJobs() throws Exception {

    }

    @Test
    public void deleteJob() throws Exception {
        doNothing().when(jobService).delete(anyLong());
    }

}