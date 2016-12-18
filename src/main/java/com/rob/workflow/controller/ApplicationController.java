package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import com.rob.workflow.service.ApplicationService;
import com.rob.workflow.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicationMapper.toDto;
import static com.rob.workflow.mapper.ApplicationMapper.toEntity;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    private JobServiceImpl jobService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto){
        Application application = applicationService.createApplication(toEntity(applicationDto));
        return new ResponseEntity<>(toDto(application), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public List<ApplicationDto> getApplications(){
        return applicationService.getApplications().stream().map(ApplicationMapper::toDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationDto> updateApplication(@RequestBody ApplicationDto applicationDto, @PathVariable Long id){
        Application application = applicationService.getApplication(id);
        //invoker action dynamically.
        application.restoreState();
        if(applicationDto.getUpdateAction() != null){
            if(applicationDto.getUpdateAction().equals("accept"))
                application.next();
            if(applicationDto.getUpdateAction().equals("reject"))
                application.reject();
            if(applicationDto.getUpdateAction().equals("withdraw"))
                application.withdraw();
        }
        application.setStateString();
        Application save = applicationService.save(application);
        ApplicationDto applicationDto1 = toDto(save);
        return new ResponseEntity<>(applicationDto1, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteOne(id);
    }

}
