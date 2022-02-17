package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final List<String> messagesHeard = new ArrayList<>();
    private final Network network;

    public Person(Network network) {
        this.network = network;
        network.subscribe(this);
    }


    public void moveTo(Integer distance) {
    }

    public void shout(String message) {
        network.broadcast(message);
    }

    public void addMessage(String message)
    {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }
}