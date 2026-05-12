public class NumberTile extends Tile{
/**creates a number tile with the specified value
 * 
 * @param newValue the new value of the tile
 */
  public NumberTile(int newValue){
    super(newValue);
  }
  
  public int getValue(){
    return super.getValue();
  }
  public String getSymbol(){ 
    return super.getSymbol();
  }
  /** returns false because the tile is a number tile
   * @return false boolean because the tile has a number
   */
  public boolean isEmpty(){
    return false;
  }
  public String toString(){
    return super.getSymbol();
  }

}
