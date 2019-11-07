import java.util.Scanner;

public class RandomNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Guess the number");

        for(int i = 10; i <= 50; i += 10) {
            playLevel(i);
            if(i < 50) {
                System.out.println("Let's complicate!");
            }
        }
        System.out.println("Today is your day :)");
        scanner.close();
    }

    private static void playLevel(int range) {
        int number = (int) (Math.random() * range);
        while(true) {
            System.out.println("Write a number from 0 to " + range);
            int input = scanner.nextInt();
            if(input == number) {
                System.out.println("Lucky! You guessed it!");
                break;
            }
            else if(input > number) {
                System.out.println("The number is less.");
            }
            else if(input < number) {
                System.out.println("The number of more.");
            }
        }
    }
}
