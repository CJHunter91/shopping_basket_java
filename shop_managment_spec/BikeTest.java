import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BikeTest{
  
  private Bike bike;

  @Before
  public void before(){
    bike = new Bike("Road", 100.0, "Red", 20);
  }

  @Test
  public void canCreateBike(){
    assertEquals(true, bike instanceof Bike);
  }

  @Test
  public void canGetBikeId(){
    assertEquals(1, bike.getId());
  }

  @Test
  public void canGetName(){
    assertEquals("Road", bike.getName());
  }

  @Test
  public void canGetPrice(){
    assertEquals(100.0, bike.getPrice(), 0.01);
  }

  @Test
  public void isBogof(){
    assertEquals(false, bike.isBogof());
  }

  @Test
  public void canSetBogof(){
    bike.setBogof();
    assertEquals(true, bike.isBogof());
  }
}