package rockpaperscissors;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        boolean inProgress = true;
        while (inProgress) {
            String playerChoice = scan.next();
            if (playerChoice.equals("!exit")) {
                System.out.println("Bye!");
                inProgress = false;
                continue;
            }
            String computerChoice = makeComputerChoice();
            play(playerChoice, computerChoice);
        }
    }

    public static void play(String playerChoice, String computerChoice) {
        switch (playerChoice) {
            case "rock":
                if (computerChoice.equals("rock")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                } else if (computerChoice.equals("paper")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                }
                break;
            case "paper":
                if (computerChoice.equals("paper")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                } else if (computerChoice.equals("scissors")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                }
                break;
            case "scissors":
                if (computerChoice.equals("scissors")) {
                    System.out.printf("There is a draw (%s)%n", playerChoice);
                } else if (computerChoice.equals("rock")) {
                    System.out.printf("Sorry, but the computer chose %s%n", computerChoice);
                } else {
                    System.out.printf("Well done. The computer chose %s and failed%n", computerChoice);
                }
                break;
            default:
                System.out.print("Invalid input");
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
