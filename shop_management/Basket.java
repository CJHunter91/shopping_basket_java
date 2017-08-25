package shop_management;

import java.util.ArrayList;

public class Basket{

  private boolean loyalty;
  private ArrayList<Item> basket;

  public Basket(boolean loyalty){
    this.loyalty = loyalty;
    this.basket = new ArrayList<>();
  }

  public boolean isLoyal(){
    return this.loyalty;
  }

  public int getCount(){
    return this.basket.size();
  }

  public  void addToBasket(Item item){
    this.basket.add(item);
  }

  public void removeLastItem(){
    this.basket.remove(getCount() - 1);
  }
}