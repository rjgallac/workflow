package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.mapper.JobMapper;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.JobMapper.toDto;
import static com.rob.workflow.mapper.JobMapper.toEntity;

@RestController
public class JobController {

    private final JobServiceImpl jobService;

    @Autowired
    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }


    @RequestMapping(value = "/job/", method = RequestMethod.POST)
    public ResponseEntity<JobDto> saveJob(@RequestBody JobDto jobDto){
        return new ResponseEntity<>(toDto(jobService.saveJob(toEntity(jobDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/job/", method = RequestMethod.GET)
    public ResponseEntity<List<JobDto>> getJobs(){
        Optional<List<Job>> jobs = jobService.getJobs();
        if(jobs.isPresent()) {
            return new ResponseEntity<>(jobs.get().stream().map(JobMapper::toDto).collect(Collectors.toList()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,null, HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/job/{id}", method = RequestMethod.GET)
    public ResponseEntity<JobDto> getJob(@PathVariable Long id){
        Optional<Job> job = jobService.getJob(id);
        if(job.isPresent()) {
            return new ResponseEntity<>(toDto(job.get()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/job/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JobDto> updateJobs(@RequestBody JobDto jobDto, @PathVariable Long id){
        Job job = jobService.getJob(id).get();
        //invoker action dynamically.
        job.restoreState();
        if(jobDto.getUpdateAction() != null){
            if(jobDto.getUpdateAction().equals("next"))
                job.next();
            if(jobDto.getUpdateAction().equals("previous"))
                job.previous();
        }
        job.setStateString();
        Job save = jobService.saveJob(job);
        JobDto jobDto1 = toDto(save);
        return new ResponseEntity<>(jobDto1, null, HttpStatus.OK);
    }
    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id){
        jobService.delete(id);
    }
}
