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
    public ResponseEntity<ApplicationDto> updateApplications(@RequestBody ApplicationDto applicationDto, @PathVariable Long id){
        Application application = applicationService.getApplication(id);
        //invoker action dynamically.
        if(applicationDto.getUpdateAction() != null){
            if(applicationDto.getUpdateAction().equals("accept"))
                application.next();
            if(applicationDto.getUpdateAction().equals("reject"))
                application.reject();
            if(applicationDto.getUpdateAction().equals("withdraw"))
                application.withdraw();
        }
        Application save = applicationService.save(application);
        ApplicationDto applicationDto1 = ApplicationMapper.toDto(save);
        return new ResponseEntity<>(applicationDto1, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteOne(id);
    }

}
