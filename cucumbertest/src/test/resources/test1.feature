Feature: basic google2
  @allTests
  Scenario: It should do homepage
    Given I am on the home page
    When I click the jobsaccord
#    When I click the job menu
    When I enter the job "jobby"
    When I click the addjob
    Then I see homepage

  @allTests
  Scenario: It should add applicant
    Given I am on the home page
    When I click the applicantaccord
    When I click the applicant menu
    When I enter the applicant "jobby"
    When I click the add applicant
    Then I see homepage
#
#  @allTests
#  Scenario: It should add application
#    Given I am on the home page
#    When I click the applicationAccord
#    When I click the appmenu
#    When I enter the appname "jobby"
#    When I select job
#    When I select applicant
#    When I click the addapp
#    Then I see homepage
