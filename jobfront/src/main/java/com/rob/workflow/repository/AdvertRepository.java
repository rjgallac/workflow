package com.rob.workflow.repository;

import com.rob.workflow.model.Advert;
import com.rob.workflow.model.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends CrudRepository<Advert, Long> {
}
