package com.rob.workflow.service;

import com.rob.workflow.model.Job;
import com.rob.workflow.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Optional getJobs() {
        return Optional.of((List)jobRepository.findAll());
    }

    public Job saveJob(Job job){
        return jobRepository.save(job);
    }

    public Job actionJob(Job job, String action){
        job.restoreState();
        if(action != null){
            if(action.equals("next"))
                job.next();
            if(action.equals("previous"))
                job.previous();
        }
        job.setStateString();
        return jobRepository.save(job);

    }

    public void delete(Long id) {
        jobRepository.delete(id);
    }

    public Optional<Job> getJob(Long id) {
        return Optional.of(jobRepository.findOne(id));
    }
}
