package com.rob.workflow.repository;

import com.rob.workflow.model.Applicant;
import com.rob.workflow.model.Application;
import com.rob.workflow.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository  extends CrudRepository<Application, Long> {
    List<Application> findByApplicant(Applicant applicant);
    List<Application> findByJob(Optional<Job> applicant);
}

