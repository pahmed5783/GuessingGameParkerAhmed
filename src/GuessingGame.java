import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int difficulty=0;
        int guess = 0;
        int num = 0;//catching errors setting to -1
        int guessCounter = 1; //the number of guesses start at 1
        Scanner input = new Scanner(System.in);
        System.out.println("Hello user! What is your name?");
        String userName = input.nextLine();
        System.out.println("Hello " + userName + ", nice to meet you!");
        int gameChoice = 0;
        System.out.println(userName + ", Which game do you want to play?");
        System.out.println("Game 1 - I will generate a number and you will have to guess it");
        System.out.println("Game 2 - You will give me a number 1-100 and I will guess it!");
        System.out.println("Type '1' for game 1. Type '2' for game 2");
        while (gameChoice == 0) {
            try {
                gameChoice = input.nextInt();
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Please type either '1' or '2'!  >:(");
                input.nextLine();
            }
        }

        //OBJECTIVE 1 GAME
        if (gameChoice == 1) {
            System.out.println("OKAY! " + userName + " I will be generating a random number 1-x and you will have to guess it!");
            System.out.println("Choose a difficulty:");
            System.out.println("Type '1' for a random number 1-10");
            System.out.println("Type '2' for a random number 1-100");
            System.out.println("Type '3' for a random number 1-1000");
            System.out.println("Type '4' for a random number 1-10000");
            while (difficulty == 0) {
                try {
                    difficulty = input.nextInt();
                    continue;
                } catch (InputMismatchException e) {
                    System.out.println("Please type either '1', '2', '3' or '4'!  >:(");
                    input.nextLine();
                }
            }
            if (difficulty == 1) {
                num = (int) (Math.random() * 10 + 1);
            }
            if (difficulty == 2) {
                num = (int) (Math.random() * 100 + 1);
            }
            if (difficulty == 3) {
                num = (int) (Math.random() * 1000 + 1);
            }
            if (difficulty == 4) {
                num = (int) (Math.random() * 10000 + 1);
            }
            System.out.println(userName + " what is your first guess?");
            guess = input.nextInt();
            while (guess != num) {
                int guessNumDiff = guess - num;
                if (guessNumDiff > 0) {
                    System.out.println("The number is smaller than that~~");
                    guess = input.nextInt();
                }
                if (guessNumDiff < 0) {
                    System.out.println("The number is bigger than that~~");
                    guess = input.nextInt();
                }
                guessCounter++;
            }
            System.out.println("CONGRADULATIONS! YOU GOT IT! " + userName + " The number was: " + num);
            System.out.println("That took you " + guessCounter + " guesses");
        }

        //OBJECTIVE 2 GAME
        if (gameChoice == 2) {
            guessCounter = 0;
            int min = 1;
            int max = 100;
            guess = 50;
            String userAdvice = "";
            System.out.println("LET'S PLAY " + userName + "! Give me a number 1-100");
            //check in case user trolls and input a string
            while (num == 0) {
                try {
                    num = input.nextInt();
                    continue;
                } catch (InputMismatchException e) {
                    System.out.println("Please give me a number 1-100! >:( ");
                    input.nextLine();
                }
            }
            System.out.println("Okay! Is your number " + guess + "? TYPE 'higher', 'lower' or 'correct'");
            while (!userAdvice.equals("correct")) {
                userAdvice = input.nextLine();
                userAdvice = userAdvice.toLowerCase();
                if (userAdvice.equals("higher")) {
                    min = guess;
                    guess = (min + max) / 2;
                    System.out.println("Is your number " + guess + "?" + " TYPE 'higher', 'lower' or 'correct'");
                }
                if (userAdvice.equals("lower")) {
                    max = guess;
                    guess = (min + max) / 2;
                    System.out.println("Is your number " + guess + "?" + " TYPE 'higher', 'lower' or 'correct'");
                }
                guessCounter++;
            }
            System.out.println("Wow...It took me " + guessCounter + " tries :(");
            System.out.println("BUT HEY! I GOT IT! That was fun " + userName + "!");
        }
    }
}


