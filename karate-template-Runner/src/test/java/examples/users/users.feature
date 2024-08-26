Feature: Contract Testing for API Server

  Background:
    * url baseUrl

  Scenario: Test GET /message
    Given path 'users'
    When method get
    Then status 200
    And match response == { message: 'Hello, world!' }

  Scenario: Test POST /message with valid data
    Given path 'users'
    And request { message: 'Hello from Karate!' }
    When method post
    Then status 201
    And match response == { message: 'Hello from Karate!' }

  Scenario: Test POST /message with missing data
    Given path 'users'
    And request {}
    When method post
    Then status 400
    And match response.error == 'Message is required'
