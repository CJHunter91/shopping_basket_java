package shop_management;

public class Bike extends Item{

  protected int gearNumber;
  protected String colour;
  protected long id;

  public Bike(String colour, int gearNumber, String name, double price){
    super(name, price);
    this.colour = colour;
    this.gearNumber = gearNumber;
    this.id = 1;
  }

  @Override
  public long getId(){
    return this.id;
  }
}