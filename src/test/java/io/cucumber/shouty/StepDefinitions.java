package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person sean;
    private Person lucy;
    private String messageFromSean;
    private Network network;
    private HashMap<String, Person> people;

    @Before
    public void createNetwork(){
        network = new Network();
        people = new HashMap<>();
    }



    @When("{word} shouts {string}")
    public void sean_shouts(String name, String message) {
        people.get(name).shout(message);
        messageFromSean = message;
    }
    @Then("{word} hears {word}'s message")
    public void lucy_hears_sean_s_message(String calleName, String callerName) {
        assertEquals(asList(messageFromSean), people.get(calleName).getMessagesHeard());
    }


    @Given("a person named {word}")
    public void a_person_named(String name) {
        people.put(name, new Person(network));
    }
//    @Given("a person named Sean")
//    public void a_person_named_sean() {
//        sean = new Person(network);
//    }
}
