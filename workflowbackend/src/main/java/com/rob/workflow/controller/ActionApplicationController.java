package com.rob.workflow.controller;

import com.rob.workflow.dto.ActionApplicationDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Application;
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
public class ActionApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ActionApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/actionapplication/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long id, @RequestBody ActionApplicationDto actionApplicationDto){
        Application application = applicationService.getApplication(id);
        Application application1 = applicationService.actionApplication(application, actionApplicationDto.getUpdateAction());
        return new ResponseEntity<>(toDto(application1), null, HttpStatus.OK);
    }
}
