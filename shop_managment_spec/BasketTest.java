import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BasketTest{
  @Test
  public void isLoyal(){
    Basket basket = new Basket(false);
    assertEquals(false, basket.isLoyal());
  }
}