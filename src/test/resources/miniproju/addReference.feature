Feature: User can add a reference to the database

  Scenario: user can add a reference
    Given uusi viite is selected
    When nimi The title of the work and kirjoittaja Peter Babington and publisher The name of the publisher and julkaisuvuosi 1993 and julkaisijan osoite The address and painos 3 are entered
    Then the reference is added and user is returned to the front page