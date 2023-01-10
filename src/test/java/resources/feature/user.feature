Feature: Testing User creation and editing

  Scenario Outline: Create a new user
    When I create a new user by providing the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Examples:
      | name | email            | gender | status |
      | shah | mshah2@gmail.com | Male   | Active |


  Scenario: Get User details
    Then I get user information by id

  Scenario Outline: Update  user details
    When Update user details by providing the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Examples:
      | name | email          | gender | status |
      | shah | shah@gmail.com | Male   | Active |


    Scenario: Delete user details
      Then The user id deleted successfully








