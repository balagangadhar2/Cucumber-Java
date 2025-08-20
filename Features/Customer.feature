Feature: customers

  Scenario: Add new Customers
    Given Launch the Chrome browser
    When Enter the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Enter the username "admin@yourstore.com" and password "admin"
    And Click on the login button
    Then Navigate to homepage with title "Dashboard / nopCommerce administration"
    When click on scustomer menu
    And click on customers
    And click on add new customer
    Then User can view Add new customer page
    When  usre enter the customer info
    And click on save
    Then user can seen the "The new customer has been added successfully."
    And close browser;