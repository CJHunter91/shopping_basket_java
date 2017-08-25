import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BasketTest{

  Basket basket;
  Item item;

  @Before
  public void before(){
    basket = new Basket(false);
    item = new Item("socks", 20);
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

}