import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class ItemTest{

  @Test
  public void canGetItemName(){
    Item item = new Item("socks", 10);
    assertEquals("socks", item.getName());
  }

  @Test
  public void canGetPrice(){
    Item item = new Item("socks", 10);
    assertEquals(10, item.getPrice());
  }
}