Feature: As student, I want to get question of the day so that I can train myself

  Scenario: first time of the day student connect to the app
    Given student ask for question
    When student as no answer question
    Then give him the question

  Scenario: Student already answer is question
    Given student ask for question
    When student as already answer question
    Then give him is answers