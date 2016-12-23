package com.rob.workflow.repository;

import com.rob.workflow.model.ApplicationHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends CrudRepository<ApplicationHistory, Long> {

}

