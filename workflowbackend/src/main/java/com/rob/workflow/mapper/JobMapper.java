package com.rob.workflow.mapper;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;

public class JobMapper {

    public static Job toEntity(JobDto jobDto){
        Job job = new Job(jobDto.getJobId(), jobDto.getName(), "com.rob.workflow.model.shortworkflow.StartState");
        job.setUpdateAction(jobDto.getUpdateAction());
        return job;
    }

    public static JobDto toDto(Job job){
        job.restoreState();
        return new JobDto(job.getJobId(), job.getName(), job.getJobState().getState().getValidStatuses(), job.getJobState().getState().getStatusReadble(), job.getApplicationStartState());
    }
}
