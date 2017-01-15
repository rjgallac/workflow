Feature: basic happy path
  @allTests
  Scenario: It should add job
    Given I am on the home page
    When I click the jobsaccord
    When I enter the job "jobby" in job box
    When I click the add job

    When I click the applicantaccord
    When I click the applicant menu
    When I enter the applicant "jobby"
    When I click the add applicant

    When I click the applicationAccord
    When I click the appmenu
    When I enter the appname "jobby"
    When I select job
    When I select applicant
    When I click the addapp
    Then I see homepage
