package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hmpo.util.ConfigLoader;

import static org.junit.Assert.*;

/**
 * contains cucumber steps to support feature file to retrieve bitcoin price
 */
public class BitCoinPriceSteps {
    private Response response;

    @Given("the CoinDesk API is available")
    public void the_coin_desk_api_is_available(){
        RestAssured.baseURI = ConfigLoader.getBitCoinApiBaseUrl();
    }

    @When("I fetch the current Bitcoin price")
    public void i_fetch_the_current_bit_coin_price(){
        response = RestAssured.given().when().get("/v1/bpi/currentprice.json");
        assertEquals(200,response.getStatusCode());
        assertNotNull(response);
    }

    @Then("I should be able to print the Bitcoin price in GBP")
    public void i_should_be_able_to_print_the_bit_coin_price_in_gbp(){
        String rate = response.then().extract().path("bpi.GBP.rate");
        System.out.println("Current Bitcoin price in GBP: " + rate);
        assertNotNull(rate);
    }

    @Then("I should be able to print the Bitcoin price in USD")
    public void i_should_be_able_to_print_the_bit_coin_price_in_usd(){
        String rate = response.then().extract().path("bpi.USD.rate");
        System.out.println("Current Bitcoin price in USD: " + rate);
        assertNotNull(rate);
    }

    @Then("I should be able to print the Bitcoin price in EUR")
    public void i_should_be_able_to_print_the_bit_coin_price_in_eur(){
        String rate = response.then().extract().path("bpi.EUR.rate");
        System.out.println("Current Bitcoin price in EUR: " + rate);
        assertNotNull(rate);
    }

}
