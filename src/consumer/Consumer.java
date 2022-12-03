package consumer;

import buffer.Bathroom;

/**
 * A consumer thread
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class Consumer extends Thread {
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
    public Consumer(String name, Bathroom bathroom, int personId) {
        super(name);
        this.bathroom = bathroom;
        this.personId = personId;
    }

    /**
     * Removes a person into the buffer
     */
    @Override
    public void run() {
        bathroom.remove(personId);
    }
}
