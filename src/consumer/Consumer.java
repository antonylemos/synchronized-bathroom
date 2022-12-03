package consumer;

import buffer.Bathroom;
import person.Person;

public class Consumer extends Thread {
    private Bathroom bathroom;
    private int personId;

    public Consumer(String name, Bathroom bathroom, int personId) {
        super(name);
        this.bathroom = bathroom;
        this.personId = personId;
    }

    @Override
    public void run() {
        bathroom.remove(personId);
    }
}
