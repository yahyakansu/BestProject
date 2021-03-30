$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/userRules.feature");
formatter.feature({
  "name": "User Rules",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AllProducts"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@User"
    }
  ]
});
formatter.scenario({
  "name": "User can login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AllProducts"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@User"
    },
    {
      "name": "@UserCredential"
    }
  ]
});
formatter.step({
  "name": "user on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "UserRulesStepDefs.user_on_the_homepage()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat utilities.Driver.getDriver(Driver.java:22)\n\tat stepDefs.UserRulesStepDefs.user_on_the_homepage(UserRulesStepDefs.java:20)\n\tat ✽.user on the homepage(src/test/resources/features/userRules.feature:5)\n",
  "status": "failed"
});
formatter.step({
  "name": "user write correct username",
  "keyword": "When "
});
formatter.match({
  "location": "UserRulesStepDefs.user_write_correct_username()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user write correct password",
  "keyword": "When "
});
formatter.match({
  "location": "UserRulesStepDefs.user_write_correct_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user write correct company code",
  "keyword": "When "
});
formatter.match({
  "location": "UserRulesStepDefs.user_write_correct_company_code()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user click the button",
  "keyword": "When "
});
formatter.match({
  "location": "UserRulesStepDefs.user_click_the_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user enter the app",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRulesStepDefs.user_enter_the_app()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "User has to select from the available sub agents to proceed further",
  "description": "    with manual transaction process or upload transaction process.",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AllProducts"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@User"
    },
    {
      "name": "@UserSelectAgent"
    }
  ]
});
formatter.step({
  "name": "user on the user page",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user select a sub agent",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user should see the transaction page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});