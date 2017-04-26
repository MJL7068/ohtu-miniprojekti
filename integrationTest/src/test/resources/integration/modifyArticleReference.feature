Feature: User can modify previously added article reference

  Scenario: user can change the title of an article reference
    Given user is in the main page and there is a reference with the title "abckiria" in the database
    When edit button for reference titled "abckiria" is clicked
    And value "se wsi testamenti" is entered to a field with name "title"
    And edit is confirmed
    Then page has reference titled "se wsi testamenti"
