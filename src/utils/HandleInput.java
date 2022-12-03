package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleInput {
    public static final int readNumber() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int numCapacity = scanner.nextInt();

        return numCapacity;
    }
}
