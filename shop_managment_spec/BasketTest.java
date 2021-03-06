import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BasketTest{

  Basket basket;
  Item item;
  Bike bike;

  @Before
  public void before(){
    basket = new Basket(false);
    item = new Item("socks", 5.0);
    bike = new Bike("MTB", 150.0, "Green", 11);
  }

  @Test
  public void isLoyal(){
    assertEquals(false, basket.isLoyal());
  }

  @Test
  public void canGetEmptyBasketCount(){
    assertEquals(0, basket.getCount());
  }

  @Test
  public void canAddItemToBasket(){
    basket.addToBasket(item);
    assertEquals(1, basket.getCount());
  }

  @Test
  public void canAddMoreItemsToBasket(){
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(3, basket.getCount());
  }

  @Test
  public void canRemoveItemFromBasket(){
    basket.addToBasket(item);
    basket.removeLastItem();
    assertEquals(0, basket.getCount());
  }

  @Test
  public void canClearBasket(){
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.clearBasket();
    assertEquals(0, basket.getCount());
  }

  @Test 
  public void canGetTotal(){
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(10.0, basket.getTotal(), 0.01);
  }

  @Test
  public void canGetLoyaltyDiscount(){
    Basket loyalBasket = new Basket(true);
    loyalBasket.addToBasket(item);
    loyalBasket.addToBasket(item);
    assertEquals(9.8, loyalBasket.getTotal(), 0.01);
  }

  @Test
  public void canGetDiscountOver20WithoutLoyalty(){
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(22.50, basket.getTotal(), 0.01);
  }

  @Test
  public void canGetDiscountOver20WithLoyalty(){
    Basket loyalBasket = new Basket(true);
    loyalBasket.addToBasket(item);
    loyalBasket.addToBasket(item);
    loyalBasket.addToBasket(item);
    loyalBasket.addToBasket(item);
    loyalBasket.addToBasket(item);
    assertEquals(22.05, loyalBasket.getTotal(), 0.01);
  }

  @Test
  public void canGetBogofDiscount(){
    item.setBogof();
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(5, basket.getTotal(), 0.01);
  }

  @Test
  public void canGetBogofDiscountWithMoreItems(){
    item.setBogof();
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(10, basket.getTotal(), 0.01);
  }

  @Test
  public void testBogoffWith3Items(){
    item.setBogof();
    basket.addToBasket(item);
    basket.addToBasket(item);
    basket.addToBasket(item);
    assertEquals(10, basket.getTotal(), 0.01);
  }

  @Test 
  public void testBogoffOnlyRemovesValidItemsFromTotal(){
    item.setBogof();
    basket.addToBasket(item);
    basket.addToBasket(item);
    Item item2 = new Item("socks", 5.0);
    basket.addToBasket(item2);
    basket.addToBasket(item2);
    assertEquals(15, basket.getTotal(), 0.01);
  }

  @Test
  public void testBogoffWithDifferentObjectsOfSameClass(){
    item.setBogof();
    basket.addToBasket(item);
    Item item2 = new Item("socks", 5.0);
    item2.setBogof();
    basket.addToBasket(item2);
    assertEquals(5, basket.getTotal(), 0.01);
  }

  @Test
  public void canAddBikesAndItemsToBasket(){
    basket.addToBasket(item);
    basket.addToBasket(bike);
    assertEquals(2, basket.getCount());
  }

  @Test
  public void bogofOnBikesAndItems(){
    item.setBogof();
    bike.setBogof();
    basket.addToBasket(item);
    basket.addToBasket(bike);
    assertEquals(139.5, basket.getTotal(), 0.01);
  }


}