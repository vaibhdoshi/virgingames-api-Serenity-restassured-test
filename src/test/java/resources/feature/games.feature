Feature: Testing the functionality of Get Bingo Lobby Feed

  Scenario:Verify that default game frequency has been set to 300000
    When User sends a Get request to the Get Bingo Lobby Feed end point
    Then verifies that default game frequency should be 300000 not null.


