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

    final Person getPersonById(int personId) {
        return bathroom.stream().filter(currentPerson ->
                currentPerson.getId() == personId
        ).findFirst().orElse(null);
    }

    public synchronized void insert(Person person) {
        while (bathroom.size() >= capacity || !(currentGender == person.getGender() || bathroom.isEmpty())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bathroom.add(person);
        currentGender = person.getGender();

        System.out.println("Added gender: " + person.getGender());
        System.out.println("Current quantity: " + bathroom.size());

        notify();
    }

    public synchronized void remove(int personId) {
        Person person = getPersonById(personId);

        while (person == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                person = getPersonById(personId);
            }
        }

        try {
            Thread.sleep(person.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bathroom.remove(person);

        System.out.println("Current quantity: " + bathroom.size());

        notify();
    }
}
