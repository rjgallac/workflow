package com.rob.workflow.mapper;

import com.rob.workflow.dto.JobDto;
import com.rob.workflow.model.Job;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobMapperTest {
    @Test
    public void toEntity() throws Exception {
        JobDto jobDto = new JobDto(1L, "test");
        Job job = JobMapper.toEntity(jobDto);
        assertEquals(jobDto.getName(), job.getName());
    }

    @Test
    public void toDto() throws Exception {
        Job job = new Job(1L, "test");
        JobDto jobDto = JobMapper.toDto(job);
        assertEquals(job.getName(), jobDto.getName());
    }

}