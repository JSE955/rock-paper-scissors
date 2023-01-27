package rockpaperscissors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        String computerChoice = "";
        String playerChoice = scan.next();

        switch (playerChoice) {
            case "paper":
                computerChoice = "scissors";
                break;
            case "scissors":
                computerChoice = "rock";
                break;
            case "rock":
                computerChoice = "paper";
                break;
            default:
                break;
        }

        System.out.printf("Sorry, but the computer chose %s", computerChoice);
    }
}
