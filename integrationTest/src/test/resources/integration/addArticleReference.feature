Feature: User can add an article reference to the database

Scenario: user can add an article reference
Given uusi viite is selected
When "article" is selected and title "Infusing active learning into introductory programming courses" and author "Whittington, Keith J." and journal "J. Comput. Small Coll." and year "2004" and volume "19" and number "5" are entered
Then the reference is added and user is returned to the front page