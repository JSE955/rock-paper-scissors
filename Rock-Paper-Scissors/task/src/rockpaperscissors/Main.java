package rockpaperscissors;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scan = new Scanner(System.in);
        int score = 0;

        System.out.print("Enter your name: ");
        String playerName = scan.next();
        System.out.printf("Hello, %s%n", playerName);

        score = checkScoreFile(playerName);

        while (true) {
            String playerChoice = scan.next();
            if (playerChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }
            String computerChoice = makeComputerChoice();
            score += play(playerChoice, computerChoice, score);
        }
    }

    public static int play(String playerChoice, String computerChoice, int currentScore) {
        int scoreToReturn = 0;
        switch (playerChoice) {
            case "!rating":
                System.out.printf("Your rating: %d%n", currentScore);
                break;
            case "rock":
                if (computerChoice.equals("rock")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                    scoreToReturn = 50;
                } else if (computerChoice.equals("paper")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                    scoreToReturn = 100;
                }
                break;
            case "paper":
                if (computerChoice.equals("paper")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                    scoreToReturn = 50;
                } else if (computerChoice.equals("scissors")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                    scoreToReturn = 100;
                }
                break;
            case "scissors":
                if (computerChoice.equals("scissors")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                    scoreToReturn = 50;
                } else if (computerChoice.equals("rock")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                    scoreToReturn = 100;
                }
                break;
            default:
                System.out.print("Invalid input");
                break;
        }
        return scoreToReturn;
    }

    public static String makeComputerChoice() {
        Random random = new Random();
        int option = random.nextInt(3);
        if (option == 0) {
            return "rock";
        } else if (option == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static int checkScoreFile(String playerName) {
        int scoreToReturn = 0;
        File file = new File("rating.txt");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                if (fileScanner.next().equals(playerName)) {
                    scoreToReturn = fileScanner.nextInt();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        return scoreToReturn;
    }
}
