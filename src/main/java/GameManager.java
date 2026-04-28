import java.util.ArrayList;
import java.util.Scanner;

public class GameManager{
  private Board board;
  private String name;
  private int moveCount;
  private ArrayList<String> moveHistory;



  
  public GameManager(){
    this.board = new Board();
    this.moveHistory = new ArrayList<String>();
  }
  public void startGame(){
    //welcome player:
    System.out.println("Welcome to 2048!");
    //get name:
    Scanner input = new Scanner(System.in);
    System.out.println("Enter name: ");
    this.name = input.nextLine();
    System.out.println("Welcome " + this.name + "!\n\n");
    displayHelpMenu();
  //spawn 2 new tiles
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

    // spawn new tile
    int row2;
    int col2;

    while(true){
        row2 = (int)(Math.random() * 4);
        col2 = (int)(Math.random() * 4);

        if(board.getTile(row2, col2).isEmpty()){
            break;
        }
    }

    int value2 = (Math.random() < 0.9) ? 2 : 4;
    board.addNumberTile(row2, col2, value2);

    
  //start move count as 0
    this.moveCount = 0;
    System.out.println("\n\nTotal Moves: " + this.moveCount + "\n\n");
    //print board 
    System.out.println(this.board.toString());
    
    input.close();
  }

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
  private void makeMove(String direction){
    //check for valid move in that direction?
    //spawn new tile
  
    // perform move
  
    this.board.slide(direction);
    // update move count + history
    this.moveCount++;
    this.moveHistory.add(direction);

    // spawn new tile
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

    // print board + score
    System.out.println(board);
    System.out.println("Score: " + board.getScore());
}
  

  private void statusUpdate(){
    System.out.println("Name: " + this.name);
    System.out.println("Current Score: " + board.getScore());
    System.out.println("Total Moves Made: " + this.moveCount);
  }

  private void showHistory(){
    System.out.println(this.moveHistory);
  }

  private void displayHelpMenu(){
    System.out.println("Help Menu:");
    System.out.println("W - slide tiles up \nA - slide tiles left \nS - slide tiles down \nD - slide tiles right");
    System.out.println("P - show the player status line \n? - redisplay the help menu \nQ - quit the game \nH - show history");
  }

  public void quitGame(){
    System.out.println("Final Score: " + this.board.getScore());
    System.out.println("Total Moves: " + this.moveCount);
    System.out.println("Thank you for playing 2048!");
  }
 




  
}