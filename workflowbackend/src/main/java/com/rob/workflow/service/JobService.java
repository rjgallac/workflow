package com.rob.workflow.service;

import com.rob.workflow.model.Job;

import java.util.Optional;

interface JobService {
    Optional getJobs();
    Job saveJob(Job job);
    void delete(Long id);
    Optional<Job> getJob(Long id);
}
