insert into applicant(name) values ("test applicant1");
insert into applicant(name) values ("test applicant2");

insert into job(name, workflow_state_string, application_start_state) values ("job 1", "com.rob.workflow.model.jobstate.JobStartState", "com.rob.workflow.model.shortworkflow.StartState");
insert into job(name, workflow_state_string, application_start_state) values ("job 2", "com.rob.workflow.model.jobstate.JobStartState", "com.rob.workflow.model.shortworkflow.StartState");

insert into application(name, applicant_applicant_id, job_job_id, workflow_state_string)
values ("test", 1, 1, "com.rob.workflow.model.shortworkflow.StartState");
insert into application(name, applicant_applicant_id, job_job_id, workflow_state_string)
values ("test", 1, 2, "com.rob.workflow.model.shortworkflow.StartState");
insert into application(name, applicant_applicant_id, job_job_id, workflow_state_string)
values ("test", 1, 1, "com.rob.workflow.model.shortworkflow.StartState");
