package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Person> personsSubscribed = new ArrayList<>();
    //private List<String> messagesBroadcasted = new ArrayList<>();
    public void subscribe(Person person)
    {
        personsSubscribed.add(person);
    }


    public void broadcast(String message) {
        for (Person p:personsSubscribed)
        {
            p.addMessage(message);
        }

    }
}
