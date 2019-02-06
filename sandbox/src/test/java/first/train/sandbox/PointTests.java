package first.train.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test

  public void testDistance(){

      Point p1 = new Point(7.0, 6.0);
      Point p2 = new Point(9.0, 1.0);
     // System.out.println(p1.distance(p2));
     Assert.assertEquals(p1.distance(p2), 5.385164807134504);

  }



}
