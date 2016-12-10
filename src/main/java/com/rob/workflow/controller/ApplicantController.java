package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.mapper.ApplicantMapper;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "/applicant/", method = RequestMethod.POST)
    public ApplicantDto saveApplicant(@RequestBody Applicant applicant){
        Applicant applicant1 = applicantService.saveApplicant(applicant);
        return ApplicantMapper.toDto(applicant1);
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.GET)
    public List<Applicant> getApplicants(){
        List<Applicant> applicants = applicantService.getApplicants();
        return applicants;
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.PUT)
    public void updateApplications(@PathVariable Long id){
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable long id){
        applicantService.delete(id);
    }

}
