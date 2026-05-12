import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {

        GameManager gm = new GameManager();
        Scanner input = new Scanner(System.in);
        gm.startGame(input);
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
