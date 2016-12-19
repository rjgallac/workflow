package com.rob.workflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private Long applicantId;

    private String name;

    public Applicant() {
    }

    public Applicant(Long applicantId, String name) {
        this.applicantId = applicantId;
        this.name = name;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public String getName() {
        return name;
    }

}
