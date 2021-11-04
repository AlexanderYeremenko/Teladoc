@webTable
Feature: User Management Practice tests

  Background: Open WebTable page

    Given I open WebTable page

  @addUser
  Scenario: Adding new user
    When I click "Add User" button
    And I enter following data:
      | first name | Alexander     |
      | last name  | Yeremenko     |
      | user name  | inamorento    |
      | password   | 12334         |
      | role       | Customer      |
      | email      | alex@alex.com |
      | cell phone | 123-45-56     |

    And I click "Save" button
    Then I verify an additional line was added to the table
    Then I verify new UserName "inamorento" was added to the table

  @deleteUser
  Scenario: Deleting new user
    When I click "Delete Novak User" button
    Then I verify a line was removed from the table
    Then I verify UserName "novak" is no longer in the table



