Feature: basic happy path
  @allTests
  Scenario: It should add job
    Given I am on the home page
    When I click the job menu
    When I enter the job "jobby" in job box
    When I click the add job

    When I click the applicant menu
    When I enter the applicant "jobby"
    When I click the add applicant

    When I click the applications menu
    When I enter the appname "jobby"
    When I select job
    When I select applicant
    When I click the addapp
    Then I see homepage
