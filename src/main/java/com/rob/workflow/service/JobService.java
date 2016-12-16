package com.rob.workflow.service;

import com.rob.workflow.model.Job;
import java.util.List;
import java.util.Optional;

interface JobService {
    List<Job> getJobs();
    Job saveJob(Job job);
    void delete(Long id);
    Optional<Job> getJob(Long id);
}
