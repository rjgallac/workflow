package com.rob.workflow.mapper;

import com.rob.workflow.dto.ApplicantDto;
import com.rob.workflow.model.Applicant;

public class ApplicantMapper {
    public static ApplicantDto toDto(Applicant applicant){
        return new ApplicantDto(applicant.getApplicantId(), applicant.getName());
    }

    public static Applicant toEntity(ApplicantDto applicantDto){
        return new Applicant(applicantDto.getApplicantId(), applicantDto.getName());
    }
}
