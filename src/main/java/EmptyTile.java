public class EmptyTile extends Tile{

  public EmptyTile(){
    super(0);
  }
  public int getValue(){
    return 0;
  }
  public String getSymbol(){
    return "0";
  }
  public boolean isEmpty(){
    return true;
  }
  public String toString(){
    return "| |";
  }
}