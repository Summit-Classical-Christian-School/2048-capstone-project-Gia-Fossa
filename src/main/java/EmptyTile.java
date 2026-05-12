public class EmptyTile extends Tile{

/** Creates an empty tile with a value of zero
*/
  public EmptyTile(){
    super(0);
  }
  public int getValue(){
    return 0;
  }
  public String getSymbol(){
    return "0";
  }
  /** returns true because the tile is an empty tile
   * @return true boolean because the tile is empty
   */
  public boolean isEmpty(){
    return true;
  }
  /** returns the empty tile's display symbol
   * @return empty display symbol
   */
  public String toString(){
    return "| |";
  }
}