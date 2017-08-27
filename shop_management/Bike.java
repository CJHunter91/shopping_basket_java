package shop_management;

public class Bike extends Item{

  protected int gearNumber;
  protected String colour;

  public Bike(String colour, int gearNumber, String name, double price){
    super(name, price);
    this.colour = colour;
    this.gearNumber = gearNumber;
  }
}