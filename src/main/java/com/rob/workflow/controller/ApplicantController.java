package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.mapper.ApplicantMapper;
import com.rob.workflow.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicantMapper.toDto;
import static com.rob.workflow.mapper.ApplicantMapper.toEntity;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "/applicant/", method = RequestMethod.POST)
    public ApplicantDto saveApplicant(@RequestBody ApplicantDto applicantDto){
        return toDto(applicantService.saveApplicant(toEntity(applicantDto)));
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.GET)
    public List<ApplicantDto> getApplicants(){
        return applicantService.getApplicants()
                .stream()
                .map(ApplicantMapper::toDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.PUT)
    public void updateApplicant(@PathVariable Long id){
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable long id){
        applicantService.delete(id);
    }

}
