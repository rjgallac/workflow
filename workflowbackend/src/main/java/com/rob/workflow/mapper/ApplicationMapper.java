package com.rob.workflow.mapper;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.dto.ApplicationDto;
import com.rob.workflow.dto.ApplicationHistoryDto;
import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.ApplicationHistory;
import com.rob.workflow.model.Job;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMapper {
    public static Application toEntity(ApplicationDto applicationDto) {
        Job job = JobMapper.toEntity(applicationDto.getJobDto());
        Applicant applicant = ApplicantMapper.toEntity(applicationDto.getApplicantDto());
        Application application = new Application(applicationDto.getApplicationId(), applicationDto.getName(), job, applicant, applicationDto.getStartState());
        application.setUpdateAction(applicationDto.getUpdateAction());
        return application;
    }

    public static ApplicationDto toDto(Application application) {
        JobDto jobDto = JobMapper.toDto(application.getJob());
        List<ApplicationHistory> applicationHistory = application.getApplicationHistory();
        List<ApplicationHistoryDto> applicationHistoryDtos = new ArrayList<>();
        for (ApplicationHistory history : applicationHistory) {
            applicationHistoryDtos.add(ApplicationHistoryMapper.toDto(history));
        }


        ApplicantDto applicantDto = ApplicantMapper.toDto(application.getApplicant());
        application.restoreState();
        ApplicationDto applicationDto = new ApplicationDto(application.getApplicationId(), application.getName(), applicantDto, jobDto, application.getWorkflowState().getState().getStatusReadble(), null, application.getWorkflowState().getState().getValidStatuses());
        applicationDto.setApplicationHistoryDtos(applicationHistoryDtos);
        return applicationDto;
    }
}
