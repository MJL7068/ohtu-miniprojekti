Feature: User can add an inproceedings reference to the database

Scenario: user can add an inproceedings reference
Given uusi viite is selected
When "inproceedings" is selected and title "A practical approach to integrating active and collaborative learning into the introductory computer science curriculum" and author "Grissom, Scott" and booktitle "Proceedings of the seventh annual consortium on Computing in small colleges midwestern conference" and year "2000" and pages "95-100" and publisher "Consortium for Computing Sciences in Colleges" are entered
Then the reference is added and user is returned to the front page
