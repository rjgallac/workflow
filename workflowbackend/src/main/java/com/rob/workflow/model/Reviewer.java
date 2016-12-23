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
}
