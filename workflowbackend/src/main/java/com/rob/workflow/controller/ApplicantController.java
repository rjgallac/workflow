package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.mapper.ApplicantMapper;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.service.ApplicantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicantMapper.toDto;
import static com.rob.workflow.mapper.ApplicantMapper.toEntity;

@RestController
public class ApplicantController {

    private ApplicantServiceImpl applicantService;

    @Autowired
    public ApplicantController(ApplicantServiceImpl applicantService) {
        this.applicantService = applicantService;
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.POST)
    public ResponseEntity<ApplicantDto> saveApplicant(@RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(toDto(applicantService.saveApplicant(toEntity(applicantDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.GET)
    public ResponseEntity<List<ApplicantDto>> getApplicant(){
        return new ResponseEntity<>(applicantService.getApplicants()
                .stream()
                .map(ApplicantMapper::toDto)
                .collect(Collectors.toList()), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApplicantDto> getApplicant(@PathVariable Long id){
        Optional<Applicant> applicant = applicantService.getApplicant(id);
        if(applicant.isPresent()){
            return new ResponseEntity<>(ApplicantMapper.toDto(applicant.get()), null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.PUT)
    public void updateApplicant(@PathVariable Long id){
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable long id){
        applicantService.delete(id);
    }

}
