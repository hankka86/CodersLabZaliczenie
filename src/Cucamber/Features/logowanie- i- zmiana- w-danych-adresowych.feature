Feature: Zadanie1
  Scenario: user loguje sie danymi defniwanymi przez testera
    Given otwieramy przegladarke https://qloapps.coderslab.pl/pl/logowanie?back=my-account
    When  podajemy dane do zalogowania email i password
    Then  klikamy w
    And   close