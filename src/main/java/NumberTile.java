public class NumberTile extends Tile{

  public NumberTile(int newValue){
    super(newValue);
  }
  
  public int getValue(){
    return super.getValue();
  }
  public String getSymbol(){ 
    return super.getSymbol();
  }
  public boolean isEmpty(){
    return false;
  }
  public String toString(){
    return super.getSymbol();
  }

}
