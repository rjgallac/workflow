package com.rob.workflow.mapper;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobMapperTest {


    @Test
    public void toEntity() throws Exception {
        JobMapper jobMapper = new JobMapper();
        JobDto jobDto = new JobDto(1L, "test",null, null, "com.rob.workflow.model.shortworkflow.StartState");
        Job job = JobMapper.toEntity(jobDto);
        assertEquals(jobDto.getName(), job.getName());
    }

    @Test
    public void toDto() throws Exception {
        Job job = new Job(1L, "test", "com.rob.workflow.model.shortworkflow.StartState");
        JobDto jobDto = JobMapper.toDto(job);
        assertEquals(job.getName(), jobDto.getName());
    }

}