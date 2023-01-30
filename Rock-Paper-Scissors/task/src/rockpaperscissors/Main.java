package rockpaperscissors;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scan = new Scanner(System.in);
        int score = 0;
        String[] gameOptions;

        System.out.print("Enter your name: ");
        String playerName = scan.nextLine();
        System.out.printf("Hello, %s%n", playerName);

        score = checkScoreFile(playerName);

        String options = scan.nextLine();
        if (options.equals("")) {
            gameOptions = new String[] {"rock", "paper", "scissors"};
        } else {
            gameOptions = options.split(",");
        }
        System.out.println("Okay, let's start");

        while (true) {
            String playerChoice = scan.next();
            if (playerChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }
            String computerChoice = makeComputerChoice(gameOptions);
            score += play(playerChoice, computerChoice, score, gameOptions);
        }
    }

    public static int play(String playerChoice, String computerChoice,
                                    int currentScore, String[] gameOptions) {
        int scoreToReturn = 0;
        ArrayList<String> relations = new ArrayList<String>();
        int i = Arrays.asList(gameOptions).indexOf(playerChoice) + 1;
        while (relations.size() != gameOptions.length - 1) {
            if (i >= gameOptions.length) {
                i = 0;
            }
            relations.add(gameOptions[i]);
            i++;
        }
        if (playerChoice.equals("!rating")) {
            System.out.printf("Your rating: %d%n", currentScore);
        } else if (Arrays.asList(gameOptions).indexOf(playerChoice) == -1) {
            System.out.println("Invalid input");
        } else if (playerChoice.equals(computerChoice)) {
            System.out.printf("There is a draw (%s)%n", playerChoice);
            scoreToReturn = 50;
        } else if (relations.indexOf(computerChoice) < gameOptions.length / 2) {
            System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
        } else {
            System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
            scoreToReturn = 100;
        }
        return scoreToReturn;
    }

    public static String makeComputerChoice(String[] array) {
        Random random = new Random();
        int option = random.nextInt(array.length);
        return array[option];
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
