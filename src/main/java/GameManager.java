import java.util.ArrayList;
import java.util.Scanner;

public class GameManager{
  private Board board;
  private String name;
  private int moveCount;
  private ArrayList<String> moveHistory;



  /**Creates game manager object with board and move history instantiated
   * 
   */
  public GameManager(){
    this.board = new Board();
    this.moveHistory = new ArrayList<String>();
  }
  /** starts new game, gets player's name, displays help menu, and spawns new tiles in the printed grid
   * @param scanner takes a scanner object
   * 
   */
  /**
   * Precondition: A scanner object must have been created, as well as a Game Manager object
   * Postcondition: Player's name is stored as instance variable, and the board now has two tiles spawned in it
   */
  public void startGame(Scanner scanner){
    //welcome player:
    System.out.println("Welcome to 2048!");
    //get name:
    System.out.println("Enter name: ");
    this.name = scanner.nextLine().toUpperCase();
    System.out.println("Welcome " + this.name + "!\n\n");
    displayHelpMenu();
  //spawn 2 new tiles
  spawnTile();
  spawnTile();
  //start move count as 0
    this.moveCount = 0;
    System.out.println("\n\nTotal Moves: " + this.moveCount + "\n\n");
    //print board 
    System.out.println(this.board.toString());
  }

  /** choses which method to call based on the command the user types
   * 
   * @param command string which is a one letter command from the user
   */
  public void command(String command){
    if(command.equalsIgnoreCase("A") || command.equalsIgnoreCase("S") || command.equalsIgnoreCase("W") || command.equalsIgnoreCase("D")){
        makeMove(command);
    }
    else if(command.equalsIgnoreCase("P")){
      statusUpdate();
    }
    else if(command.equalsIgnoreCase("?")){
      displayHelpMenu();
    }
    else if(command.equalsIgnoreCase("H")){
      showHistory();
    }
    else{
      System.out.println("Invalid command, please try again.");
    }
  }
/** checks for win or loss, then merges tiles, updates movecount and history, then prints board and score
 * 
 * @param direction string to pass through to the slide method
 */
  private void makeMove(String direction){
    //check for valid move in that direction?
    //spawn new tile
  
    // perform move
  if(!this.board.hasValidMove()){
    quitGameLoss();
  }
  if(this.board.hasWin()){
    quitGameWin();
  }
    this.board.slide(direction);
    // update move count + history
    this.moveCount++;
    this.moveHistory.add(direction);

    // spawn new tile
    spawnTile();

    // print board + score
    System.out.println(board);
    System.out.println("Score: " + board.getScore());
}
/**
 * creates a random row and col for a random tile value and adds it to the grid
 */
  private void spawnTile(){
     //spawn new tiles
    int row;
    int col;

    while(true){
        row = (int)(Math.random() * 4);
        col = (int)(Math.random() * 4);

        if(board.getTile(row, col).isEmpty()){
            break;
        }
    }

    int value = (Math.random() < 0.9) ? 2 : 4;
    board.addNumberTile(row, col, value);
  }
/**
 * prints status update for the player, including name, score, and total moves
 */
  private void statusUpdate(){
    System.out.println("Name: " + this.name);
    System.out.println("Current Score: " + board.getScore());
    System.out.println("Total Moves Made: " + this.moveCount);
  }
/**
 * prints each direction made in the game from the 
 */
  private void showHistory(){
    System.out.println("Move History: ");
    for(int i = 0; i < moveHistory.size(); i++){
      String move = moveHistory.get(i).toUpperCase();
      if(move.equals("W")){
       System.out.println("Up");
      }
      else if(move.equals("A")){
        System.out.println("Left");
      }
      else if(move.equals("S")){
        System.out.println("Down");
      }
      else if(move.equals("D")){
        System.out.println("Right");
      }
    }
  }
/**
 * Prints all command keys and their function
 */
  private void displayHelpMenu(){
    System.out.println("Help Menu:");
    System.out.println("W - slide tiles up \nA - slide tiles left \nS - slide tiles down \nD - slide tiles right");
    System.out.println("P - show the player status line \n? - redisplay the help menu \nQ - quit the game \nH - show history");
  }
/**
 * Prints message for a lost game
 */
  public void quitGameLoss(){
    System.out.println("You have no valid moves. Game over " + this.name);
    System.out.println("Final Score: " + this.board.getScore());
    System.out.println("Final Board:");
    this.board.toString();
    System.out.println("Total Moves: " + this.moveCount);
    showHistory();
    System.out.println("Thank you for playing 2048!");
  }
/**
 * prints message for a won game
 */
  public void quitGameWin(){
    System.out.println("You have won 2048! Congrats " + this.name + "!");
    System.out.println("Final Score: " + this.board.getScore());
    System.out.println("Final Board:");
    this.board.toString();
    System.out.println("Total Moves: " + this.moveCount);
    showHistory();
    System.out.println("Thank you for playing 2048!");
  }
 /**
  * prints message for a game quit in the middle
  */
 public void quitGameIncomplete(){
    System.out.println("Game is Incomplete but ended. Nice try " + this.name);
    System.out.println("Final Score: " + this.board.getScore());
    System.out.println("Final Board:");
    this.board.toString();
    System.out.println("Total Moves: " + this.moveCount);
    showHistory();
    System.out.println("Thank you for playing 2048!");
  }




  
}