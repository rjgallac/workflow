package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto){
        Application application1 = ApplicationMapper.toEntity(applicationDto);
//        application1.next();
        Application application = applicationService.createApplication(application1);
        ApplicationDto applicationDtoSaved = ApplicationMapper.toDto(application);
        return new ResponseEntity<>(applicationDtoSaved, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public List<ApplicationDto> getApplications(){
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        List<Application> applications = applicationService.getApplications();
        applicationDtos.addAll(applications.stream().map(ApplicationMapper::toDto).collect(Collectors.toList()));
        return applicationDtos;
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
    public void updateApplications(@PathVariable Long id){
        Application application = applicationService.getApplication(id);
        application.next();
        applicationService.save(application);
    }

}
