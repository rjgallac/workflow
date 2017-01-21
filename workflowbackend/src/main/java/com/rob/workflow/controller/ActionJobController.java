package com.rob.workflow.controller;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.mapper.JobMapper;
import com.rob.workflow.model.ActionJobDto;
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
public class ActionJobController {

    private final JobServiceImpl jobService;

    @Autowired
    public ActionJobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }


    @RequestMapping(value = "/actionjob/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JobDto> actionJob(@RequestBody ActionJobDto actionJobDto, @PathVariable Long id){
        Job job = jobService.getJob(id).get();
        //invoker action dynamically.
        Job save = jobService.actionJob(job, actionJobDto.getUpdateAction());
        return new ResponseEntity<>(toDto(save), null, HttpStatus.OK);
    }
}
