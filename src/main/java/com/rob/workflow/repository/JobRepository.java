package com.rob.workflow.repository;

import com.rob.workflow.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

}

