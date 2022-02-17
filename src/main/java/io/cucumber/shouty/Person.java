package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final List<String> messagesHeard = new ArrayList<>();
    private final Network network;
    private int location;

    public Person(Network network, int location) {
        this.network = network;
        network.subscribe(this);
        this.location = location;
    }


    public void shout(String message) {
        network.broadcast(message, this.location);
    }

    public void addMessage(String message)
    {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
