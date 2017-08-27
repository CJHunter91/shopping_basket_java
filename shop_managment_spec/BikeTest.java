import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;

public class BikeTest{

  @Test
  public void canCreateBike(){
    Bike bike = new Bike("Red", 20, "Road", 100.0 );
    assertEquals(true, bike instanceof Bike);
  }
}