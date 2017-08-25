package shop_management;

public class Basket{

  private boolean loyalty;

  public Basket(boolean loyalty){
    this.loyalty = loyalty;
  }

  public boolean isLoyal(){
    return this.loyalty;
  }
}