@ignore
Feature: User Tracking API

  Background:
    * url baseUrl

  Scenario Outline: delete user id

    Given path '/users/'+<uid>
    When method delete
    Then status <statusCode>
    And assert response.code == <errorCode>
    And assert response.message == <errorMessage>

    Examples:
      | uid                                    | statusCode | errorCode                | errorMessage                            |
      | null                                   | 400        | "400 BAD_REQUEST"        | "invalid uuid i18n"                     |
#      | "ss"                                   | 400        | "400 BAD_REQUEST"        | "invalid uuid i18n"                     |
#      | "null"                                 | 400        | "400 BAD_REQUEST"        | "invalid uuid i18n"                     |
#      | "44ea6cd0-9d7d-11ea-bb37-0242ac130002" | 404        | "404 NOT_FOUND"          | "user id not found"                     |
#      | ""                                     | 405        | "405 METHOD_NOT_ALLOWED" | "Request method 'DELETE' not supported" |
