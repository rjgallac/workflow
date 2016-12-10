package com.rob.workflow.mapper;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;

public class ApplicationMapper {
    public static Application toEntity(ApplicationDto applicationDto) {
        Job job = JobMapper.toEntity(applicationDto.getJobDto());
        Applicant applicant = ApplicantMapper.toEntity(applicationDto.getApplicantDto());
        return new Application(applicationDto.getName(), job, applicant, applicationDto.getStartState());
    }

    public static ApplicationDto toDto(Application application) {
        JobDto jobDto = JobMapper.toDto(application.getJob());
        ApplicantDto applicantDto = ApplicantMapper.toDto(application.getApplicant());
        return new ApplicationDto(application.getApplicationId(), application.getName(), applicantDto, jobDto, application.getWorkflowStateString(), null);
    }
}
