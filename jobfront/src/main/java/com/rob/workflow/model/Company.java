package com.rob.workflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long companyId;

    private String name;

    private String address;

    public Company() {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
