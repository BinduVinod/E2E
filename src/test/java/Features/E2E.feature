Feature:
  This feature deals with the e2e operation in the practice page

  Background:
    Given I navigated to the AutomationPractice page
    @e2e
    Scenario:
      When I select "Option2" from checkbox example
      Then same option is selected in the dropdown example
      And same option is entered in the switch to alert example
      And same option is displayed on alert message on clicking the alert button
      And I click the practice projects link inside the frame


  Scenario:
        When I select Radio3 from radiobutton example
        And I type the words on the suggestionclass example to select country
          | uni | United Kingdom (UK) |
        And I hoover over the Mouse Hover and select reload
        And I click on the newWindow button to see a new window loaded
        And I click the openTab button to see a new tab opened
        And I click the hide button to hide the text box








