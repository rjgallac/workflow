package com.rob.workflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue
    private Long reviewerId;

    private String name;

    public Reviewer() {
    }

    public Reviewer(Long reviewerId, String name) {
        this.reviewerId = reviewerId;
        this.name = name;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public String getName() {
        return name;
    }
}
