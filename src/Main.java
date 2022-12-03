import buffer.Bathroom;
import consumer.Consumer;
import producer.Producer;
import utils.HandleInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int bathroomCapacity = scanner.nextInt();

//        final int bathroomCapacity = HandleInput.readNumber();
        Bathroom bathroom = new Bathroom(bathroomCapacity);

        System.out.print("Enter the number: ");
        int numberOfPersons = scanner.nextInt();

        Producer[] producers = new Producer[numberOfPersons];
        Consumer[] consumers = new Consumer[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            producers[i] = new Producer("Producer " + i, bathroom, i);
            consumers[i] = new Consumer("Producer " + i, bathroom, i);
        }

        for (int i = 0; i < numberOfPersons; i++) {
            producers[i].start();
            consumers[i].start();
        }

        try {
            for (int i = 0; i < numberOfPersons; i++) {
                producers[i].join();
                consumers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}