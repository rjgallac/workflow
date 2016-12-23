package com.rob.workflow.repository;

import com.rob.workflow.model.ApplicationHistory;
import com.rob.workflow.model.Reviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationHistoryRepository extends CrudRepository<ApplicationHistory, Long> {

}

