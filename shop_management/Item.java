package shop_management;
import behaviours.*;

public class Item implements Sellable{

  protected String name;
  protected double price;
  protected boolean bogof;
  protected long id;

  public Item(String name, double price){
    this.id = 0;
    this.name = name;
    this.price = price;
    this.bogof = false;
  }

  public long getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public double getPrice(){
    return this.price;
  }

  public void setBogof(){
    if(this.bogof){
      this.bogof = false;
    }
    else{
      this.bogof = true;
    }
  }

  public boolean isBogof(){
    return this.bogof;
  }

}