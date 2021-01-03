Feature: Login
  As user, I want to able to login with etsy, google account


Scenario: 1. Just a login with Etsy account
  Given user click on get started button
  When user logs in with etsy account
  Then user verifies that logo is displayed