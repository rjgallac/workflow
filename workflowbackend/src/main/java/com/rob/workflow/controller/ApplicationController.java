package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicationMapper.toDto;
import static com.rob.workflow.mapper.ApplicationMapper.toEntity;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(toDto(applicationService.createApplication(toEntity(applicationDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public List<ApplicationDto> getApplications(){
        return applicationService.getApplications().stream().map(ApplicationMapper::toDto).collect(Collectors.toList());
    }
    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
    public ApplicationDto getApplication(@PathVariable Long id){
        return ApplicationMapper.toDto(applicationService.getApplication(id));
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationDto> updateApplication(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(toDto(applicationService.save(ApplicationMapper.toEntity(applicationDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteOne(id);
    }

}
