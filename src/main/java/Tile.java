public class Tile{

  private int value;
  private boolean isEmpty;
  private String symbol;


  
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
  public boolean isEmpty(){
    return this.isEmpty();
  }
  public void mergeIncrement(){
    this.value*=2;
    this.symbol = String.valueOf(this.value);
    
  }
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

  
  public String toString(){
    return getDisplaySymbol();
  }

  public String tileData(){ //Print value and display symbol
    return " ";
  }


  
  
  
}