Feature: Fetch current Bitcoin price in GBP

  @GetBitcoinPrice
  Scenario: Fetch and print the Bitcoin price in GBP
    Given the CoinDesk API is available
    When I fetch the current Bitcoin price
    Then I should be able to print the Bitcoin price in GBP

  @GetBitcoinPrice
  Scenario: Fetch and print the Bitcoin price in USD
    Given the CoinDesk API is available
    When I fetch the current Bitcoin price
    Then I should be able to print the Bitcoin price in USD

  @GetBitcoinPrice
  Scenario: Fetch and print the Bitcoin price in EUR
    Given the CoinDesk API is available
    When I fetch the current Bitcoin price
    Then I should be able to print the Bitcoin price in EUR