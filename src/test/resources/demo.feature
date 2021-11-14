@math

Feature: Simple math

  @norun
  Scenario Outline: Number comparison as scenario outline
    Given a number is set to <num>
    When the number is compared to 3
    Then the result will be different
    Examples:
      | num |
      | 1   |
      | 2   |
      | 34  |

  @norun
  Scenario: Number comparison as simple scenario
    Given a number is set to 5
    When the number is compared to 3
    Then the result will be different

    #update the definitions with proper regex, maybe standard cuke exp is ok too
  @MOBDTM-5000 @addition
  Scenario: Add 10 to 5 and expect 15
    * def variable1 = 5
    * def variable2 = 10
    When the following variables are added:
      | variable1 |
      | variable2 |
    Then the result equals 15

    @MOBDTM-5001 @addition
  Scenario: Add 10 to 5 and expect 16
    * def variable1 = 5
    * def variable2 = 10
    When the following variables are added:
      | variable1 |
      | variable2 |
    Then the result equals 16

  @MOBDTM-5002 @addition
  Scenario: Add 11 to 5 and expect 16
    * def variable1 = 5
    * def variable2 = 11
    When the following variables are added:
      | variable1 |
      | variable2 |
    Then the result equals 16

  @MOBDTM-5003 @multiplication
  Scenario: Multiply 5 with 6 and get 30
    * def variable1 = 5
    * def variable2 = 6
    When the following variables are multiplied:
      | variable1 |
      | variable2 |
    Then the result equals 30

  @MOBDTM-5004 @multiplication
  Scenario: Multiply 5 with 6 and get 32
    * def variable1 = 5
    * def variable2 = 6
    When the following variables are multiplied:
      | variable1 |
      | variable2 |
    Then the result equals 32

  @MOBDTM-5005 @multiplication
  Scenario: Multiply 5 with 7 and get 35
    * def variable1 = 5
    * def variable2 = 7
    When the following variables are multiplied:
      | variable1 |
      | variable2 |
    Then the result equals 35

  @MOBDTM-5006 @multiplication
  Scenario: Multiply 6 with 6 and get 36
    * def variable1 = 6
    * def variable2 = 6
    When the following variables are multiplied:
      | variable1 |
      | variable2 |
    Then the result equals 36

  @norun
  Scenario: dataTable parsing
    When something data table:
      | 11 | 12 |
      | 21 | 22 |
      | 31 | 32 |

  @norun
  Scenario: list parsing
    When something else list:
      | 1 |
      | 2 |
      | 3 |

  @norun
  Scenario: map parsing
    When something else map:
      | key1 | val1 |
      | key2 | val2 |
      | key3 | val3 |