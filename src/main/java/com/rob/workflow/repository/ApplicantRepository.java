package com.rob.workflow.repository;

import com.rob.workflow.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

}

