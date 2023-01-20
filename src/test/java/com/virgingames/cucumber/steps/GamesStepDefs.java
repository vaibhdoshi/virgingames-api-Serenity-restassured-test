package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.GamesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class GamesStepDefs {
    static ValidatableResponse response;
    static int ventureId;
    static List<Object> defaultGameFrequencyList;


    @Steps
    GamesSteps gamesSteps;

    @When("^User sends a Get request to the Get Bingo Lobby Feed end point$")
    public void userSendsAGetRequestToTheGetBingoLobbyFeedEndPoint() {
        response = gamesSteps.getAllGamesInfo();

    }

    @Then("^verifies that default game frequency should be (\\d+) not null\\.$")
    public void verifiesThatDefaultGameFrequencyShouldBeNotNull(int frequency) {
        defaultGameFrequencyList = response.extract().
                //path will extract all the values from the entire record
                        path("bingoLobbyInfoResource.streams.defaultGameFrequency");
        System.out.println(defaultGameFrequencyList);
        for (Object defaultGameFrequency :
                defaultGameFrequencyList) {
            if (!(defaultGameFrequency == null)) {
                Assert.assertThat(defaultGameFrequency,equalTo(frequency));
            }
        }
    }

}

