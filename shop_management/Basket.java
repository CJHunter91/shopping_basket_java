package shop_management;

import java.util.*;
import behaviours.*;

public class Basket{

  private boolean loyalty;
  private ArrayList<Sellable> basket;

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

  public double getTotal(){
    double total = 0;
    for(Sellable item : basket){
      total += item.getPrice();
    }
    total = bogofDiscount(total);
    total = overTwentyDiscount(total);
    return loyalDiscount(total);
  }

  public  void addToBasket(Sellable item){
    this.basket.add(item);
  }

  public void removeLastItem(){
    this.basket.remove(getCount() - 1);
  }

  public void clearBasket(){
    this.basket.clear();
  }

  public double overTwentyDiscount(double total){
    //10% off
    if(total > 20.0){
      return total *= 0.9;
    }
    return total;
  }

  public double loyalDiscount(double total){
    if(this.loyalty){
      //2% off
      total *= 0.98;
    }
    return total;
  }


  public double bogofDiscount(double total){
    HashMap<Sellable, Integer> itemCount = new HashMap<>();
    ArrayList<Sellable> temp = new ArrayList<>();

    //loop through the basket and add any bogof items to the temp array and hash
    // 1 is added to keys that already exist in the hash
    for(Sellable item : basket){
      if(itemCount.containsKey(item)){
        itemCount.put(item, itemCount.get(item) + 1);
      }
      else if(item.isBogof()){
        itemCount.put(item, 1);
        temp.add(item);
      }
    }
    //loop through the temp to access each itemCount to determine how mush money to remove from total
    for(Sellable item : temp){
      int halfTheItems = itemCount.get(item) / 2;
      for(int i = 1; i <= halfTheItems; i++){
        total -= item.getPrice();
      }
    }
    return total;
  }
}