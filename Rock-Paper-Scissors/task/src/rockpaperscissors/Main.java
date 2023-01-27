package rockpaperscissors;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        String playerChoice = scan.next();
        String computerChoice = makeComputerChoice();
        play(playerChoice, computerChoice);
    }

    public static void play(String playerChoice, String computerChoice) {
        switch (playerChoice) {
            case "rock":
                if (computerChoice.equals("rock")) {
                    System.out.printf("There is a draw (%s)", playerChoice);
                } else if (computerChoice.equals("paper")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                }
                break;
            case "paper":
                if (computerChoice.equals("paper")) {
                    System.out.printf("There is a draw (%s)", playerChoice);
                } else if (computerChoice.equals("scissors")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                }
                break;
            case "scissors":
                if (computerChoice.equals("scissors")) {
                    System.out.printf("There is a draw (%s)", playerChoice);
                } else if (computerChoice.equals("rock")) {
                    System.out.printf("Sorry, but the computer chose %s", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed", computerChoice);
                }
                break;
            default:
                System.out.print("Invalid game.");
                break;
        }
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
}
