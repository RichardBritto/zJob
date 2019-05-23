Feature: DoneDeal WebSite

    

  @search @login
  Scenario: DoneDeal Website Application with LogIn function
    Given User is in DoneDeal website application and clicks LogIn Button
    When User enters an existing users email and password
    Then user verify the error message
    
  @search @login
  Scenario: DoneDeal Website Application with Search function
  	Given User is in DoneDeal website and clicks Car Section
  	When User do the Search function
  	Then User see the search details and verify the details with search