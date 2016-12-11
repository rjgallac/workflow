package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.mapper.JobMapper;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/job/", method = RequestMethod.POST)
    public ResponseEntity<JobDto> saveJob(@RequestBody JobDto jobDto){
        Job job = JobMapper.toEntity(jobDto);
        Job job1 = jobService.saveJob(job);
        JobDto jobDto1 = JobMapper.toDto(job1);
        return new ResponseEntity(jobDto1, null, HttpStatus.OK);

    }

    @RequestMapping(value = "/job/", method = RequestMethod.GET)
    public List<JobDto> getJobs(){

        List<Job> jobs = jobService.getJobs();
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job : jobs) {
            jobDtos.add(JobMapper.toDto(job));
        }

        return jobDtos;
    }

    @RequestMapping(value = "/job/{id}", method = RequestMethod.PUT)
    public void updateJobs(@PathVariable Long id){
    }
    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id){
        jobService.delete(id);
    }
}
