Feature: basic google2
  @allTests
  Scenario: It should do homepage
    Given I am on the home page
    Then I see homepage

  @allTests
  Scenario: It should do google
    Given I am on google
    Then I see google

#  @allTests
#  Scenario: It should do asdf
#    Given I am on the home page
#    When I click the course menu link
#    When I enter the coursename "jobby"
#    When I submit course
#
#  @allTests
#  Scenario: It should do asdf1
#    Given I am on the home page
#    When I click the course menu link
#    When I enter the coursename "jobby2"
#    When I submit course