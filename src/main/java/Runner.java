import java.util.Scanner;

/**
 * Main entry point for the 2048 game.
 *
 * This is your starting point. Build your game by adding classes
 * and implementing the game logic as described in your project handout.
 */

public class Runner {
    public static void main(String[] args) {

        GameManager gm = new GameManager();
        gm.startGame();
        Scanner input = new Scanner(System.in);
        System.out.println("Input Command: ");
     
        String command = input.nextLine();
        while (!command.equalsIgnoreCase("Q")) {
            gm.command(command);
            System.out.println("\n\nInput Command: ");
            command = input.nextLine();
        }
        if (command.equalsIgnoreCase("Q")) {
            gm.quitGameIncomplete();
        }
        input.close();

    }
}
