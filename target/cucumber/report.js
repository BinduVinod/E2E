$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Features/E2E.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "This feature deals with the e2e operation in the practice page",
  "id": "",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I navigated to the AutomationPractice page",
  "keyword": "Given "
});
formatter.match({
  "location": "E2ESteps.iNavigatedToTheAutomationPracticePage()"
});
formatter.result({
  "duration": 19294009500,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "",
  "description": "",
  "id": ";",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I select \"option2\" in checkbox example",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "\"option2\" is selected from the dropdown example",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "\"option2\" is entered in the textbox and alert button is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I see \"option2\" in the alert message and clicked OK",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "option2",
      "offset": 10
    }
  ],
  "location": "E2ESteps.iSelectInCheckboxExample(String)"
});
formatter.result({
  "duration": 103817100,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat Steps.E2ESteps.iSelectInCheckboxExample(E2ESteps.java:41)\r\n\tat ✽.When I select \"option2\" in checkbox example(src/test/java/Features/E2E.feature:8)\r\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "option2",
      "offset": 1
    }
  ],
  "location": "E2ESteps.isSelectedFromTheDropdownExample(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 210500,
  "status": "passed"
});
});