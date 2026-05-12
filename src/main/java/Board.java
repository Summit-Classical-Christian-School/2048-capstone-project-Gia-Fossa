public class Board{

  private Tile[][] grid;
  private int score;
  /**
 * creates board with a grid filled with empty tiles
 */
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
/** adds a number tile to the board
 * 
 * @param row the row to add the tile
 * @param col the col to add the tile
 * @param val the value of the added tile
 */
  public void addNumberTile(int row, int col, int val){
    grid[row][col] = new NumberTile(val);
    
  }
/**checks for a 2048 in the grid to enable win
 * 
 * @return boolean hasWin returns true if there is a 2048
 */
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
/**checks for a valid move in the grid
 * 
 * @return boolean hasValidMove if a valid move exists
 */
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
    for (int row = 0; row < grid.length - 1; row++) {

        int value3 = grid[row][col].getValue();
        int value4 = grid[row + 1][col].getValue();

        if (value3 == value4) {
            return true;
        }
    }
}
      return false;
  }

/**calls the slide method according to the direction given
 * 
 * @param direction the direction to determine the direction of the slide
 */
/**
 * Precondition: The string direction must be either w, s, d, or a, and the grid must not be empty
 * Postcondition: The method correctly calls the slide method associated with the right direction
 */
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
  /**compresses values, merges them, then slides them to the right
   * 
   */
  /**
   * Precondition: a board is created that isn't full
   * Postcondition: all tiles are correctly merged to the right and are all on the right side
   */
private void slideRight(){

   for(int row = 0; row < grid.length; row++){

    // compress right
   int curIndex = grid[0].length - 1;

    for(int col = grid[0].length - 1; col >= 0; col--){

      if(!grid[row][col].isEmpty()){

                if(col != curIndex){
                    grid[row][curIndex] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex--;
            }
        }

        for(int col = curIndex; col >= 0; col--){
            grid[row][col] = new EmptyTile();
        }

        // merge
        for(int col = grid[0].length - 1; col > 0; col--){

            if(!grid[row][col].isEmpty() &&
               grid[row][col].getValue() == grid[row][col - 1].getValue()){

                grid[row][col].mergeIncrement();
                this.score += grid[row][col].getValue();

                grid[row][col - 1] = new EmptyTile();

                col--;
            }
        }

        // compress again
        curIndex = grid[0].length - 1;

        for(int col = grid[0].length - 1; col >= 0; col--){

            if(!grid[row][col].isEmpty()){

                if(col != curIndex){
                    grid[row][curIndex] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex--;
            }
        }

        for(int col = curIndex; col >= 0; col--){
            grid[row][col] = new EmptyTile();
        }
    }
}
  /**compresses values, merges them, then slides them to the left
   * 
   */
private void slideLeft(){

    for(int row = 0; row < grid.length; row++){

        // compress left
        int curIndex = 0;

        for(int col = 0; col < grid[0].length; col++){

            if(!grid[row][col].isEmpty()){

                if(col != curIndex){
                    grid[row][curIndex] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex++;
            }
        }

        for(int col = curIndex; col < grid[0].length; col++){
            grid[row][col] = new EmptyTile();
        }

        // merge
        for(int col = 0; col < grid[0].length - 1; col++){

            if(!grid[row][col].isEmpty() &&
               grid[row][col].getValue() == grid[row][col + 1].getValue()){

                grid[row][col].mergeIncrement();
                this.score += grid[row][col].getValue();

                grid[row][col + 1] = new EmptyTile();

                col++;
            }
        }

        // compress again
        curIndex = 0;

        for(int col = 0; col < grid[0].length; col++){

            if(!grid[row][col].isEmpty()){

                if(col != curIndex){
                    grid[row][curIndex] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex++;
            }
        }

        for(int col = curIndex; col < grid[0].length; col++){
            grid[row][col] = new EmptyTile();
        }
    }
}
/**compresses values, merges them, then slides them up
   * 
   */
   private void slideUp(){

    for(int col = 0; col < grid[0].length; col++){

        // compress up
        int curIndex = 0;

        for(int row = 0; row < grid.length; row++){

            if(!grid[row][col].isEmpty()){

                if(row != curIndex){
                    grid[curIndex][col] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex++;
            }
        }

        for(int row = curIndex; row < grid.length; row++){
            grid[row][col] = new EmptyTile();
        }

        // merge
        for(int row = 0; row < grid.length - 1; row++){

            if(!grid[row][col].isEmpty() &&
               grid[row][col].getValue() == grid[row + 1][col].getValue()){

                grid[row][col].mergeIncrement();
                this.score += grid[row][col].getValue();

                grid[row + 1][col] = new EmptyTile();

                row++;
            }
        }

        // compress again
        curIndex = 0;

        for(int row = 0; row < grid.length; row++){

            if(!grid[row][col].isEmpty()){

                if(row != curIndex){
                    grid[curIndex][col] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex++;
            }
        }

        for(int row = curIndex; row < grid.length; row++){
            grid[row][col] = new EmptyTile();
        }
    }
}
/**compresses values, merges them, then slides them down
   * 
   */
   private void slideDown(){

    for(int col = 0; col < grid[0].length; col++){

        // compress down
        int curIndex = grid.length - 1;

        for(int row = grid.length - 1; row >= 0; row--){

            if(!grid[row][col].isEmpty()){

                if(row != curIndex){
                    grid[curIndex][col] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex--;
            }
        }

        for(int row = curIndex; row >= 0; row--){
            grid[row][col] = new EmptyTile();
        }

        // merge
        for(int row = grid.length - 1; row > 0; row--){

            if(!grid[row][col].isEmpty() &&
               grid[row][col].getValue() == grid[row - 1][col].getValue()){

                grid[row][col].mergeIncrement();
                this.score += grid[row][col].getValue();

                grid[row - 1][col] = new EmptyTile();

                row--;
            }
        }

        // compress again
        curIndex = grid.length - 1;

        for(int row = grid.length - 1; row >= 0; row--){

            if(!grid[row][col].isEmpty()){

                if(row != curIndex){
                    grid[curIndex][col] = grid[row][col];
                    grid[row][col] = new EmptyTile();
                }

                curIndex--;
            }
        }

        for(int row = curIndex; row >= 0; row--){
            grid[row][col] = new EmptyTile();
        }
    }
}
 
public Tile getTile(int row, int col){
    return grid[row][col];
}
  /**returns grid of the display symbols
   * @return string of the board
   */
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