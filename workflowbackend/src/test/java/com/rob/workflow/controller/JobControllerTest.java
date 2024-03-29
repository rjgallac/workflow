package com.rob.workflow.controller;

import com.rob.workflow.dto.JobAndApplicationsDto;
import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.JobServiceImpl;
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
        Job test1 = new Job(1L, "test", "com.rob.workflow.model.shortworkflow.StartState");
        when(jobService.saveJob(any(Job.class))).thenReturn(test1);
        ResponseEntity<JobDto> test = jobController.saveJob(new JobDto(1L, "test", null, null, "com.rob.workflow.model.shortworkflow.StartState"));
        assertEquals("test", test.getBody().getName());
    }

    @Test
    public void getJobs() throws Exception {
        ArrayList<Job> jobsReturned = new ArrayList<>();
        jobsReturned.add(new Job(1L, "test", "com.rob.workflow.model.shortworkflow.StartState"));
        when(jobService.getJobs()).thenReturn(Optional.of(jobsReturned));
        ResponseEntity<List<JobDto>> jobs = jobController.getJobs();
        assertEquals(1, jobs.getBody().size());
    }

    @Test
    public void getJobsNoneFound() throws Exception {
        when(jobService.getJobs()).thenReturn(Optional.empty());
        ResponseEntity<List<JobDto>> jobs = jobController.getJobs();
        assertEquals(HttpStatus.NOT_FOUND, jobs.getStatusCode());
    }

    @Test
    public void getJob() throws Exception {
        Job job = new Job(1L, "test", "com.rob.workflow.model.shortworkflow.StartState");
        when(jobService.getJob(1L)).thenReturn(Optional.of(job));
        ResponseEntity<JobAndApplicationsDto> job1 = jobController.getJob(1L);
        assertEquals("test", job1.getBody().getJobDto().getName());
    }

    @Test
    public void getJobNoneFound() throws Exception {
        when(jobService.getJob(1L)).thenReturn(Optional.empty());
        ResponseEntity<JobAndApplicationsDto> job1 = jobController.getJob(1L);
        assertEquals(HttpStatus.NOT_FOUND, job1.getStatusCode());
    }

    @Test
    public void updateJobs() throws Exception {
        Job test = new Job(1L, "test", "com.rob.workflow.model.shortworkflow.StartState");
        test.setWorkflowStateString("com.rob.workflow.model.jobstate.JobStartState");
        when(jobService.getJob(1L)).thenReturn(Optional.of(test));
        when(jobService.saveJob(test)).thenReturn(test);
        jobController.updateJobs(new JobDto(),1L);
    }

    @Test
    public void deleteJob() throws Exception {
        doNothing().when(jobService).delete(anyLong());
        jobController.deleteJob(1L);
    }

}