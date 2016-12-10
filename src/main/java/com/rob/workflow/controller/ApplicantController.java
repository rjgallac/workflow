package com.rob.workflow.controller;

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
    public void saveApplicant(@RequestBody Applicant applicant){
        applicantService.saveApplicant(applicant);
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.GET)
    public List<Applicant> getApplicants(){
        List<Applicant> applicants = applicantService.getApplicants();
        return applicants;
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.PUT)
    public void updateApplications(@PathVariable Long id){
    }

}
