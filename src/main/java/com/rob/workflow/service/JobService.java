package com.rob.workflow.service;

import com.rob.workflow.model.Job;
import com.rob.workflow.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobs() {
        return (List<Job>)jobRepository.findAll();
    }

    public Job saveJob(Job job){
        return jobRepository.save(job);
    }

    public void delete(Long id) {
        jobRepository.delete(id);
    }

    public Optional<Job> getJob(Long id) {
        return Optional.of(jobRepository.findOne(id));
    }
}
