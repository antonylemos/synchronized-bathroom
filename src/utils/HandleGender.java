package utils;

import java.util.Random;

public class HandleGender {
    private static final Random random = new Random();

    public static final char generateRandomGender() {
        int randomGenderNumber = random.nextInt(2);

        return randomGenderNumber == 0 ? 'M' : 'W';
    }
}
