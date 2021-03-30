@AllProducts @Regression @User
  Feature: User Rules
    @UserCredential
    Scenario: User can login with valid credentials
      Given user on the homepage
      When user write correct username
      When user write correct password
      When user write correct company code
      When user click the button
      Then user enter the app

# It must be some scenarios for validation
#   with correct username, correct password, wrong company code
#   with correct username, wrong password, wrong company code
#   with correct username, wrong password, correct company code
#   with wrong username, correct password, correct company code
#   with wrong username, correct password, wrong company code
#   with wrong username, wrong password, correct company code
#   with wrong username, wrong password, wrong company code

    @UserSelectAgent
    Scenario: User has to select from the available sub agents to proceed further
    with manual transaction process or upload transaction process.
      Given user on the user page
      When user select a sub agent
      Then user should see the transaction page
# It needs some validation scenario before the scenario
#  user should see sub agents in drop down list
#  drop down list should contain only available sub agents ...