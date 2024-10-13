@FlightRoundTrip
Feature: MakeMyTrip Flight Booking

  Background: Browser Setup
    Given I setup browser and utilities

  Scenario: Round Trip Flight Booking
    Given I navigate to flight booking page
    And I select round trip
    And I select from city
    And I select to city
    And I select departure date
    And I select return date
    And I select travellers
    And I select type of passenger
    Then I book my flight
