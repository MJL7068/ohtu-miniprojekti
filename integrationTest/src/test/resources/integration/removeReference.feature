Feature: user can remove a reference from the database

Scenario: user can remove a reference
Given user is in the main page and there is a reference with the title "testireferenssi" in the database
When button with the text "Poista" next to the reference with the title "testireferenssi" is pressed
Then the reference with the title "testireferenssi" is removed