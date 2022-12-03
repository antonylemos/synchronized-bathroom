package person;

/**
 * The class Person
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class Person {
    private final int id;
    private final char gender;
    private final int time;

    /**
     * Parameterized constructor
     *
     * @param id     the id
     * @param gender the gender
     * @param time   the time
     */
    public Person(int id, char gender, int time) {
        this.id = id;
        this.gender = gender;
        this.time = time;
    }

    /**
     * Gets the identifier
     *
     * @return the identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the time
     *
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the gender
     *
     * @return the gender
     */
    public char getGender() {
        return gender;
    }
}
