package com.rob.workflow.model;

import javax.persistence.*;

@Entity
public class Advert {

    @Id
    @GeneratedValue
    private Long advertId;

    private String title;

    @ManyToOne
    private Company company;

    private String description;

    private String requirements;

    private double salary;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    private String location;

    private String category;

    private long applicationId;

    public Advert() {
    }

    public Long getAdvertId() {
        return advertId;
    }

    public String getTitle() {
        return title;
    }

    public Company getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public double getSalary() {
        return salary;
    }

    public Enum getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public long getApplicationId() {
        return applicationId;
    }
}
