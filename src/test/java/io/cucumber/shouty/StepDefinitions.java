package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private Person sean;
    private Person lucy;
    private String messageFromSean;
    private static final int DEFAULT_RANGE = 100;
    private Network network = new Network(DEFAULT_RANGE);
    private HashMap<String, Person> people;

    @Before
    public void createNetwork(){
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void a_person_named(String name) throws Throwable {
        people.put(name, new Person(network, 0));
    }


    @Given("the range is {int}")
    public void the_range_is(int range) throws Throwable {
        network = new Network(range);
    }

    @Given("a person named {word} is located at {int}")
    public void a_person_named_is_located(String name, int location) {
        people.put(name, new Person(network, location));
    }


    @When("Sean shouts")
    public void sean_shouts_default()
    {
        people.get("Sean").shout("Hello, world!");
        this.messageFromSean = "Hello, world!";
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        people.get("Sean").shout(message);
        messageFromSean = message;
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(asList(messageFromSean), people.get("Lucy").getMessagesHeard());
    }

    @Then("Larry should not hear Sean's message")
    public void larry_does_not_hear_Sean_s_message() {
        List<String> heardByLarry = people.get("Larry").getMessagesHeard();
        assertTrue(heardByLarry.isEmpty());
    }


}
