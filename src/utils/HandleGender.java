package utils;

import java.util.Random;

/**
 * Utility class to handle gender values
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class HandleGender {
    private static final Random random = new Random();

    /**
     * Get random gender
     *
     * @return Random gender
     */
    public static final char generateRandomGender() {
        int randomGenderNumber = random.nextInt(2);

        return randomGenderNumber == 0 ? 'M' : 'W';
    }
}
