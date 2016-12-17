package com.rob.workflow.service;

import com.rob.workflow.model.Job;
import com.rob.workflow.repository.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JobServiceImplTest {

    @Mock
    JobRepository jobRepository;

    @InjectMocks
    JobServiceImpl jobService;

    @Test
    public void getJobs() throws Exception {
        when(jobRepository.findAll()).thenReturn(new ArrayList<>());
        jobService.getJobs();
    }

    @Test
    public void saveJob() throws Exception {
        when(jobRepository.save(any(Job.class))).thenReturn(new Job());
        jobService.saveJob(new Job());
    }

    @Test
    public void delete() throws Exception {
        when(jobRepository.save(new Job())).thenReturn(new Job());
        jobService.delete(1L);
    }

    @Test
    public void getJob() throws Exception {
        jobService.getJob(1L);

    }

}