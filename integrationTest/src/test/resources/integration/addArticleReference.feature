Feature: User can add an article reference to the database

  Scenario: user can add an article reference
    Given uusi viite is selected
    When "article" is selected and title "Infusing active learning into introductory programming courses" and author "Whittington, Keith J." and journal "J. Comput. Small Coll." and year "2004" and volume "19" and number "5" are entered
    Then the reference is added and user is returned to the front page

  Scenario: user cannot add an article when mandatory fields are missing
    Given uusi viite is selected
    When "article" is selected and title "" and author "aa" and journal "j" and year "12345" and volume "2" and number "0" are entered
    Then the reference is not added and user stays on new reference page
