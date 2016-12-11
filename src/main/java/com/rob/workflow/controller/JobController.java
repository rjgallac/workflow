package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.mapper.JobMapper;
import com.rob.workflow.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.JobMapper.toDto;
import static com.rob.workflow.mapper.JobMapper.toEntity;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/job/", method = RequestMethod.POST)
    public ResponseEntity<JobDto> saveJob(@RequestBody JobDto jobDto){
        return new ResponseEntity(toDto(jobService.saveJob(toEntity(jobDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/job/", method = RequestMethod.GET)
    public List<JobDto> getJobs(){
        return jobService.getJobs().stream().map(JobMapper::toDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/job/{id}", method = RequestMethod.PUT)
    public void updateJobs(@PathVariable Long id){
    }
    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id){
        jobService.delete(id);
    }
}
