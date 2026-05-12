public class Tile{

  private int value;
  private boolean isEmpty;
  private String symbol;


  /** Creates a tile with the specified number
 * @param newValue the number value of the new tile
*/
  public Tile(int newValue){
    this.value = newValue;
    this.symbol = String.valueOf(newValue);
     
  }
  
  public int getValue(){
    return this.value;
  }
  public String getSymbol(){
    return this.symbol;
  }
  public String getDisplaySymbol(){
    return "|" + getSymbol() + "|";
  }
  /** returns whether or not the tile is empty
   * @return boolean of whether or not tile is empty
   */
  public boolean isEmpty(){
    return this.isEmpty();
  }
/**
 * increases Tile's value by multiplying it by two
 */
  public void mergeIncrement(){
    this.value*=2;
    this.symbol = String.valueOf(this.value);
    
  }
  /** Compares to objects with each other
  @return a boolean of whether or not two objects are equal
   */
  public boolean equals(Object otherObject) {
    if (otherObject == this){
     return true;
    }
    if (!(otherObject instanceof Tile)) {
     return false;
    }
    
      Tile otherTile = (Tile) otherObject;
     return this.getValue() == otherTile.getValue();
  
  }

  /** Gets the tile's symbol
 * @return A String containing the display symbol of the tile
*/
  public String toString(){
    return getDisplaySymbol();
  }



  
  
  
}