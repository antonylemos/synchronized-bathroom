package utils;

import java.util.Random;

public class HandleTime {
    private static final int MAX_TIME = 5000;
    private static final Random random = new Random();

    public static final int generateRandomTime() {
        return random.nextInt(MAX_TIME);
    }
}
