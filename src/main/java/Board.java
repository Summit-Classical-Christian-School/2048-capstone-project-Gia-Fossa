public class Board{

  private Tile[][] grid;
  private int score;

  public Board(){
    this.grid = new Tile[4][4];
    for (int row = 0; row < grid.length; row++) {
    for (int col = 0; col < grid[0].length; col++) {
     grid[row][col] = new EmptyTile();
    }
    }
  }
  
  
  public int getScore(){
    return this.score;
  }

  public void addNumberTile(int row, int col, int val){
    grid[row][col] = new NumberTile(val);
    
  }

  public boolean hasWin(){
    for (Tile[] row : grid) {
      for (Tile element : row) {
        int score = element.getValue();
        if(score == 2048){
          return true;
        }
      }
    }
    return false;
  }

  public boolean hasValidMove(){
    for (Tile[] row : grid) {
      for (Tile element : row) {
        if(element.getValue() == 0){
          return true;
        }
      }
    }
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length-1; col++) {
        int value1 = grid[row][col].getValue();
        int value2 = grid[row][col+1].getValue();
        if(value2 == value1){
          return true;
        }
      }
    }
      
    for (int col = 0; col < grid[0].length; col++) {
      for (int row = 0; row < grid.length-1; row++) {
        // use arr[row][col]
        int value3 = grid[col][row].getValue();
        int value4 = grid[col][row+1].getValue();
        if(value3 == value4){
          return true;
        }
       }
    }
      return false;
  }



  
 private void slideRight(){
   for(int row = 0; row < grid.length; row++){

        // merge
        for(int col = 0; col < grid[0].length - 1; col++){
            if(!grid[row][col].isEmpty()){
                if(grid[row][col].getValue() == grid[row][col + 1].getValue()){
                  grid[row][col+1].mergeIncrement();
                  this.score += grid[row][col+1].getValue();
                    grid[row][col] = new EmptyTile();
                    col++;
                }
            }
        }

        // shift right
        int curIndex = grid[0].length - 1;

        for(int i = grid[0].length - 1; i >= 0; i--){
            if(!grid[row][i].isEmpty()){

                if(i != curIndex){
                    grid[row][curIndex] = grid[row][i];
                    grid[row][i] = new EmptyTile();
                }

                curIndex--;
            }
        }

        // fill remaining left side
        for(int col = curIndex; col >= 0; col--){
            grid[row][col] = new EmptyTile();
        }
    }
  }
  
   public void slideLeft(){  //make prvate after testing
    for(int row = 0; row < grid.length; row++){
 for(Tile tile : grid[row]){
    
      }
      //merging all tiles
      for(int col = grid[0].length-1; col > 0; col--){
        if(!grid[row][col].isEmpty()){
            if(grid[row][col].getValue() == grid[row][col-1].getValue()){
              grid[row][col-1].mergeIncrement();
              this.score += grid[row][col-1].getValue();
              grid[row][col] = new EmptyTile();
              col--;
            }
        }
       
      }
     
      
    //shift all tiles over to the left - create new array, copy over every non empty tile
      int curIndex = 0;
      for(int i = 0; i < grid[0].length; i++){
       if(!grid[row][i].isEmpty()){
          if(i != curIndex){
        grid[row][curIndex] = grid[row][i];
        grid[row][i] = new EmptyTile();
        }
    curIndex++;
    }
        
      }
      //fill rest of array with empty tiles after shifted
      for(int col = curIndex; col < grid[0].length; col++){
    grid[row][col] = new EmptyTile();
      }
      
      
    }
  }
   private void slideUp(){
    for(int col = 0; col < grid[0].length; col++){

        // merge
        for(int row = grid.length - 1; row > 0; row--){
            if(!grid[row][col].isEmpty()){
                if(grid[row][col].getValue() == grid[row - 1][col].getValue()){
                   grid[row-1][col].mergeIncrement();
                    this.score += grid[row-1][col].getValue();
                    grid[row][col] = new EmptyTile();
                    row--;
                }
            }
        }

        // shift up
        int curIndex = 0;

        for(int i = 0; i < grid.length; i++){
            if(!grid[i][col].isEmpty()){

                if(i != curIndex){
                    grid[curIndex][col] = grid[i][col];
                    grid[i][col] = new EmptyTile();
                }

                curIndex++;
            }
        }

        // fill remaining bottom
        for(int row = curIndex; row < grid.length; row++){
            grid[row][col] = new EmptyTile();
        }
    }
}
   private void slideDown(){
    for(int col = 0; col < grid[0].length; col++){

        // merge
        for(int row = 0; row < grid.length - 1; row++){
            if(!grid[row][col].isEmpty()){
                if(grid[row][col].getValue() == grid[row + 1][col].getValue()){
                   grid[row+1][col].mergeIncrement();
                    this.score += grid[row+1][col].getValue();
                    grid[row][col] = new EmptyTile();
                    row++;
                }
            }
        }

        // shift down
        int curIndex = grid.length - 1;

        for(int i = grid.length - 1; i >= 0; i--){
            if(!grid[i][col].isEmpty()){

                if(i != curIndex){
                    grid[curIndex][col] = grid[i][col];
                    grid[i][col] = new EmptyTile();
                }

                curIndex--;
            }
        }

        // fill remaining top
        for(int row = curIndex; row >= 0; row--){
            grid[row][col] = new EmptyTile();
        }
    }
}
  
  public void slide(String direction){
    if(direction.equalsIgnoreCase("W")){
      slideUp();
    }
    if(direction.equalsIgnoreCase("A")){
      slideLeft();
    }
    if(direction.equalsIgnoreCase("S")){
      slideDown();
    }
    if(direction.equalsIgnoreCase("D")){
      slideRight();
    }
   
    
  }
 
public Tile getTile(int row, int col){
    return grid[row][col];
}
  
  public String toString(){
    String board = "";
    for (Tile[] row : grid) {
      for (Tile element : row) {
        board += element.getDisplaySymbol();
      }
      board += "\n\n";
    }
    return board;
  }

  
  
}