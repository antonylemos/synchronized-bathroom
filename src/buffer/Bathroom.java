package buffer;

import person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A bounded buffer to be shared by concurrent threads.<br/>
 * The methods for inserting into and removing from the buffer run
 * (upon threads) in mutual exclusion.
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class Bathroom {
    /**
     * Buffer's capacity
     */
    private int capacity;

    /**
     * Initial gender value
     */
    private char currentGender = 'N';

    /**
     * Buffer
     */
    private List<Person> bathroom;

    /**
     * Parameterized constructor
     *
     * @param capacity Buffer's capacity
     */
    public Bathroom(int capacity) {
        this.capacity = capacity;
        bathroom = new ArrayList<Person>();
    }

    /**
     * Find person in list by identifier
     *
     * @param personId Person identifier
     * @return Founded person
     */
    final Person getPersonById(int personId) {
        return bathroom.stream().filter(currentPerson ->
                currentPerson.getId() == personId
        ).findFirst().orElse(null);
    }

    /**
     * Inserts a person at the end of the buffer.<br/>
     * If the buffer achieved its maximum capacity, then the running producer thread
     * is suspended, otherwise it is notified for resuming execution.
     *
     * @param person Person to be inserted
     */
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

    /**
     * Removes the person at the front of the buffer.<br/>
     * If the buffer is currently empty, then the running consumer thread is suspended,
     * otherwise it is notified for resuming execution.
     */
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

        System.out.println("Removed gender: " + person.getGender());
        System.out.println("Current quantity: " + bathroom.size());

        notify();
    }
}
