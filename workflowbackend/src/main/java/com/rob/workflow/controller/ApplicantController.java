package com.rob.workflow.controller;

import com.rob.workflow.dto.ApplicantAndApplicationsDto;
import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.mapper.ApplicantMapper;
import com.rob.workflow.mapper.ApplicationMapper;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.repository.ApplicationRepository;
import com.rob.workflow.service.ApplicantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rob.workflow.mapper.ApplicantMapper.toDto;
import static com.rob.workflow.mapper.ApplicantMapper.toEntity;

@RestController
public class ApplicantController {

    private ApplicantServiceImpl applicantService;

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicantController(ApplicantServiceImpl applicantService, ApplicationRepository applicationRepository) {
        this.applicantService = applicantService;
        this.applicationRepository = applicationRepository;
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.POST)
    public ResponseEntity<ApplicantDto> saveApplicant(@RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(toDto(applicantService.saveApplicant(toEntity(applicantDto))), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant/", method = RequestMethod.GET)
    public ResponseEntity<List<ApplicantDto>> getApplicant(){
        return new ResponseEntity<>(applicantService.getApplicants().stream().map(ApplicantMapper::toDto).collect(Collectors.toList()), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/applicant/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApplicantAndApplicationsDto> getApplicant(@PathVariable Long id){
        Optional<Applicant> applicant = applicantService.getApplicant(id);

        List<Application> byApplicantId = applicationRepository.findByApplicant(applicant.get());

        if(applicant.isPresent()){
            ApplicantDto applicantDto = ApplicantMapper.toDto(applicant.get());
            List<ApplicationDto> applicationDtos = new ArrayList<>();
            for (Application application : byApplicantId) {
                applicationDtos.add(ApplicationMapper.toDto(application));
            }

            ApplicantAndApplicationsDto applicantAndApplicationsDto = new ApplicantAndApplicationsDto(applicantDto, applicationDtos);
            return new ResponseEntity<>(applicantAndApplicationsDto, null, HttpStatus.OK);
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
