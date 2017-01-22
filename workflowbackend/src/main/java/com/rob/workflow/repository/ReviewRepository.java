package com.rob.workflow.repository;

import com.rob.workflow.model.Application;
import com.rob.workflow.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findReviewsByApplication(Application application);
}

