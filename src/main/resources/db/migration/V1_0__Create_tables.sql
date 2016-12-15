create table applicant(
    applicant_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY(applicant_id)
);

create table job(
    job_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    workflow_state_string varchar(255),
    PRIMARY KEY(job_id)
);

create table application(
    application_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    workflow_state_string varchar(255),
    applicant_applicant_id bigint(20),
    job_job_id bigint(20),
    PRIMARY KEY(application_id)
);