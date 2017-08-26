package shop_management;

public class Item{

  private String name;
  private double price;
  private boolean bogof;

  public Item(String name, double price){
    this.name = name;
    this.price = price;
    this.bogof = false;
  }

  public String getName(){
    return this.name;
  }

  public double getPrice(){
    return this.price;
  }

  public boolean isBogof(){
    return this.bogof;
  }
}