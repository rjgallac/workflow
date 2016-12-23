create table applicant(
    applicant_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY(applicant_id)
);

create table job(
    job_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    workflow_state_string varchar(255),
    application_start_state varchar(255),
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

create table application_history(
    application_history_id bigint(20) NOT NULL AUTO_INCREMENT,
    history varchar(255),
    local_date_time TIMESTAMP,
    application_application_id bigint(20) NOT NULL,
    PRIMARY KEY(application_history_id)

);

create table review(
    review_id bigint(20) NOT NULL AUTO_INCREMENT,
    stage int(11) NOT NULL,
    score int(11),
    application_application_id bigint(20) NOT NULL,
    reviewer_reviewer_id bigint(20) NOT NULL,
    PRIMARY KEY(review_id)

);

create table reviewer(
    reviewer_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY(reviewer_id)
);