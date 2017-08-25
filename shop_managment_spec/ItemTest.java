import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class ItemTest{

  @Test
  public void getItemName(){
    Item item = new Item("socks", 10);
    assertEquals("socks", item.getName());
  }
}