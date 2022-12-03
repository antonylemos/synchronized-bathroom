package buffer;

import person.Person;

import java.util.ArrayList;
import java.util.List;

public class Bathroom {
    private int capacity;

    private char currentGender = 'N';

    private List<Person> bathroom;

    public Bathroom(int capacity) {
        this.capacity = capacity;
        bathroom = new ArrayList<Person>();
    }

    public synchronized void insert(Person person) {
        while (bathroom.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bathroom.add(person);

        System.out.println("Added gender: " + person.getGender());
        System.out.println("Current quantity: " + bathroom.size());

        notify();
    }

    public synchronized void remove(int personId) {
        Person person = bathroom.stream().filter(currentPerson ->
                currentPerson.getId() == personId
        ).findFirst().orElse(null);

        while (person == null) {
            try {
                wait();

                person = bathroom.stream().filter(currentPerson ->
                        currentPerson.getId() == personId
                ).findFirst().orElse(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(person.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bathroom.remove(person);

        System.out.println("Removed gender: " + person.getGender());
        System.out.println("Current quantity: " + bathroom.size());

        notify();
    }
}
