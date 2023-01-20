package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GamesSteps {
    /**
     * GamesSteps class to write methods, which have been used within cucumber steps
     */

    //@Step annotation shows the step info in Serenity Report
    @Step("Getting information on ventureID from Bingo Lobby Info Resource")
    public ValidatableResponse getAllGamesInfo() {
        return SerenityRest.rest()
                .given().log().all()
                .when()
                .get(EndPoints.GET_BINGO_LOBBY_FEED)
                .then()
                .statusCode(200).log().all()
                .parser("text/plain;charset=UTF-8", Parser.JSON);
    }

}
