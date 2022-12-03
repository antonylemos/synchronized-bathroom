package producer;

import buffer.Bathroom;
import person.Person;
import utils.HandleGender;
import utils.HandleTime;

public class Producer extends Thread {
    private Bathroom bathroom;

    private final int personId;

    public Producer(String name, Bathroom bathroom, int personId) {
        super(name);
        this.bathroom = bathroom;
        this.personId = personId;
    }

    @Override
    public void run() {
        Person person = new Person(personId, HandleGender.generateRandomGender(), HandleTime.generateRandomTime());
        bathroom.insert(person);
    }
}
