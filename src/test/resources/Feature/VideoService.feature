Feature: Testing a Video service 
  Users should be able to retrieve a video by tags and/or level


  Scenario: Data retrieval from service - No params
    When users want to get videos without params
    Then the requested data is returned (2 videos)

  Scenario: Data retrieval from service - Level
    When users want to get videos by level
    Then the requested data is returned (2 video)

  Scenario: Data retrieval from service - Tags
    When users want to get videos by tags
    Then the requested data is returned (1 videos)

  Scenario: Data retrieval from service - Tags/level
    When users want to get videos by tags
    Then the requested data is returned (1 videos)