Feature: Login feature

  Scenario: Login with valid credentials
    Given Launch the Chrome browser
    When Enter the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Enter the username "admin@yourstore.com" and password "admin"
    And Click on the login button
    Then Navigate to homepage with title "Dashboard / nopCommerce administration"
    When Click the logoff button
    Then User is navigated to the login page with title "nopCommerce demo store. Login"
    And Close the browser

    
    Scenario Outline: Login with set of data
     Given Launch the Chrome browser
     When Enter the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
     And Enter the username "<username>" and password "<password>"
     And Click on the login button
     Then Navigate to homepage with title "Dashboard / nopCommerce administration"
     When Click the logoff button
     Then User is navigated to the login page with title "nopCommerce demo store. Login"
     And Close the browser
    
    Examples:

 
      | username            | password |
      | admin@yourstore.com | admin |
      | bb                  | bbb|
       