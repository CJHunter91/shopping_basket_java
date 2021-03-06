import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class ItemTest{

  @Test
  public void canGetItemName(){
    Item item = new Item("socks", 10.0);
    assertEquals("socks", item.getName());
  }

  @Test
  public void canGetPrice(){
    Item item = new Item("socks", 10.0);
    assertEquals(10.0, item.getPrice(), 0.01);
  }

  @Test
  public void canCheckItemIsBogof(){
    Item item = new Item("socks", 10.0);
    assertEquals(false, item.isBogof());
  }
  @Test
  public void canSetBogof(){
    Item item = new Item("socks", 10.0);
    item.setBogof();
    assertEquals(true, item.isBogof());
  }
  @Test
  public void canSetBogofBackToFalse(){
    Item item = new Item("socks", 10.0);
    item.setBogof();
    item.setBogof();
    assertEquals(false, item.isBogof());
  }

  @Test
  public void canGetItemId(){
    Item item = new Item("socks", 10.0);
    assertEquals(0, item.getId());
  }
}