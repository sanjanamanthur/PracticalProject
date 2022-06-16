Feature: Post creation

 
  Scenario: Login
    Given Launch the Chrome browser
    And Open test "http://www.qaclickacademy.com/"
    And Click on Login button
    When Enter "user name" and "password"
    And Click on Login buttom
    Then User should be loggin in 
    

