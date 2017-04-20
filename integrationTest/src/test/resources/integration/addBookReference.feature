Feature: User can add a book reference to the database

Scenario: user can add a book reference
Given uusi viite is selected
When "book" is selected and title "Clean Code: A Handbook of Agile Software Craftsmanship" and author "Martin, Robert" and publisher "Prentice Hall" and year "2008" and address "The address" and edition "3" are entered
Then the reference is added and user is returned to the front page