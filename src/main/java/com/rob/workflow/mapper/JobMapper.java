package com.rob.workflow.mapper;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;

public class JobMapper {

    public static Job toEntity(JobDto jobDto){
        return new Job(jobDto.getJobId(), jobDto.getName());
    }

    public static JobDto toDto(Job job){
        return new JobDto(job.getJobId(), job.getName());
    }
}
