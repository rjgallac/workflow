package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.JobAndApplicationsDto;
import com.rob.workflow.dto.JobDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.mapper.JobMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import com.rob.workflow.repository.ApplicationRepository;
import com.rob.workflow.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.JobMapper.toDto;
import static com.rob.workflow.mapper.JobMapper.toEntity;

@RestController
public class JobController {

    private final JobServiceImpl jobService;

    private final ApplicationRepository applicationRepository;

    @Autowired
    public JobController(JobServiceImpl jobService, ApplicationRepository applicationRepository) {
        this.jobService = jobService;
        this.applicationRepository = applicationRepository;
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
    public ResponseEntity<JobAndApplicationsDto> getJob(@PathVariable Long id){
        Optional<Job> job = jobService.getJob(id);

        List<Application> byJob = applicationRepository.findByJob(job);

        if(job.isPresent()) {
            JobDto jobDto = toDto(job.get());
            List<ApplicationDto> applicationDtos = new ArrayList<>();
            for (Application application : byJob) {
                applicationDtos.add(ApplicationMapper.toDto(application));
            }
            JobAndApplicationsDto jobAndApplicationsDto = new JobAndApplicationsDto(jobDto, applicationDtos);
            return new ResponseEntity<>(jobAndApplicationsDto, null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/job/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JobDto> updateJobs(@RequestBody JobDto jobDto, @PathVariable Long id){
        Optional<Job> job = jobService.getJob(id);
        //invoker action dynamically.
        if(job.isPresent()) {
            Job save = jobService.saveJob(job.get());
            return new ResponseEntity<>(toDto(save), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id){
        jobService.delete(id);
    }
}
