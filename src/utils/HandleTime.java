package utils;

import java.util.Random;

/**
 * Utility class to handle time values
 *
 * @author <a href="mailto:lemosantony@gmail.com">Antony Lemos</a>
 * @author <a href="mailto:jonas.oliveira.111@ufrn.edu.br">Jonas de Oliveira</a>
 */
public class HandleTime {
    private static final int MAX_TIME = 5000;
    private static final Random random = new Random();

    /**
     * Get random gender
     *
     * @return Random gender
     */
    public static int generateRandomTime() {
        return random.nextInt(MAX_TIME);
    }
}
