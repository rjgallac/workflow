package com.rob.workflow.repository;

import com.rob.workflow.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository  extends CrudRepository<Application, Long> {

}

