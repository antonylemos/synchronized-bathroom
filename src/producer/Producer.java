package producer;

import buffer.Bathroom;
import person.Person;
import utils.HandleGender;
import utils.HandleTime;

/**
 * A producer thread
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class Producer extends Thread {
    /**
     * Reference to the shared buffer
     */
    private Bathroom bathroom;

    /**
     * Person identifier
     */
    private final int personId;

    /**
     * Parametized constructor
     *
     * @param name     Name to be assigned to the thread
     * @param bathroom Reference to the shared buffer
     * @param personId Person identifier
     */
    public Producer(String name, Bathroom bathroom, int personId) {
        super(name);
        this.bathroom = bathroom;
        this.personId = personId;
    }

    /**
     * Inserts a person into the buffer
     */
    @Override
    public void run() {
        Person person = new Person(personId, HandleGender.generateRandomGender(), HandleTime.generateRandomTime());
        bathroom.insert(person);
    }
}
