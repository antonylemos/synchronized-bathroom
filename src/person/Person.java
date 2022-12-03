package person;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {
//    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private final int id;
    private final char gender;
    private final int time;

    public Person(int id, char gender, int time) {
        this.id = id;
        this.gender = gender;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public char getGender() {
        return gender;
    }
}
