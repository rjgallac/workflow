package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.ApplicationHistory;
import com.rob.workflow.service.ApplicationHistoryService;
import com.rob.workflow.service.ApplicationService;
import com.rob.workflow.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicationMapper.toDto;
import static com.rob.workflow.mapper.ApplicationMapper.toEntity;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    private JobServiceImpl jobService;

    private ApplicationHistoryService applicationHistoryService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, JobServiceImpl jobService, ApplicationHistoryService applicationHistoryService) {
        this.applicationService = applicationService;
        this.jobService = jobService;
        this.applicationHistoryService = applicationHistoryService;
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
    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
    public ApplicationDto getApplication(@PathVariable Long id){
        return ApplicationMapper.toDto(applicationService.getApplication(id));
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationDto> updateApplication(@RequestBody ApplicationDto applicationDto, @PathVariable Long id){
        Application application = applicationService.getApplication(id);
        //invoker action dynamically.
        application.restoreState();
        if(applicationDto.getUpdateAction() != null){
            if(applicationDto.getUpdateAction().equals("accept")) {
                application.next();
                ApplicationHistory accept = applicationHistoryService.addHistory(new ApplicationHistory("accept", LocalDateTime.now()));
                application.addHistory(accept);
            }
            if(applicationDto.getUpdateAction().equals("reject")) {
                application.reject();
                ApplicationHistory reject = applicationHistoryService.addHistory(new ApplicationHistory("reject", LocalDateTime.now()));
                application.addHistory(reject);
            }
            if(applicationDto.getUpdateAction().equals("withdraw")) {
                application.withdraw();
                ApplicationHistory withdraw = applicationHistoryService.addHistory(new ApplicationHistory("withdraw", LocalDateTime.now()));
                application.addHistory(withdraw);
            }
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
