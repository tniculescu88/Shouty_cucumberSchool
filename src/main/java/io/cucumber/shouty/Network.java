package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Person> personsSubscribed;
    private int range;

    public Network(int range)
    {
        this.range = range;
        personsSubscribed = new ArrayList<>();
    }

    public void subscribe(Person person)
    {
        personsSubscribed.add(person);
    }


    public void broadcast(String message, int location) {
        for (Person p:personsSubscribed)
        {
            if (Math.abs(p.getLocation() - location) <= this.range)
                {p.addMessage(message);}
        }

    }
}
