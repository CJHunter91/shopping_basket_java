import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BasketTest{

  Basket basket;
  Item item;

  @Before
  public void before(){
    basket = new Basket(false);
    item = new Item("socks", 5.0);
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

}