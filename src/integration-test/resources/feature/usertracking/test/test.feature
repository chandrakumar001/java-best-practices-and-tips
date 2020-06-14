Feature: User Tracking API

  Background:
    * url baseUrl
  @ignore
  Scenario Outline: validate userNumber
    # Create  user
    * def payload =
    """
      {
        "email": <email>,
        "name": <name>
    }
    """
    Given path 'greeting'
    And request payload
    When method POST
    Then status <statusCode>
    And assert response.code == <errorCode>
    And assert response.message == <errorMessage>

    Examples:
      | testCase           | email       | name         | statusCode | errorCode         | errorMessage                                 |
      | The email is empty | ''          | chandrakumar | 400        | "400 BAD_REQUEST" | "Property 'email' must not be null or empty" |
      | The email is null  | null        | chandrakumar | 400        | "400 BAD_REQUEST" | "Property 'email' must not be null or empty" |
      | The email invalid  | test        | chandrakumar | 400        | "400 BAD_REQUEST" | "Invalid 'email' format"                     |
      | The name is empty  | chan@in.com | ''           | 400        | "400 BAD_REQUEST" | "Property 'name' must not be null or empty"  |
      | The name is null   | chan@in.com | null         | 400        | "400 BAD_REQUEST" | "Property 'name' must not be null or empty"  |

  Scenario Outline: get user id

    Given path 'greeting/'+<id>
    When method GET
    Then status <statusCode>
    And assert response.code == <errorCode>
    And assert response.message == <errorMessage>

    Examples:
      | testCase        | id   | statusCode | errorCode         | errorMessage                                 |
      | The id is empty | ''   | 400        | "400 BAD_REQUEST" | "Property 'email' must not be null or empty" |
      | The id is null  | null | 400        | "400 BAD_REQUEST" | "Property 'email' must not be null or empty" |
