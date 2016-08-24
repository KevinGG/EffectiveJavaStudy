package SimpleTests;

import java.math.BigDecimal;
import utility.ObjectOutputUtility;

public class PlayWithBigDecimal {
  public static void main (String[] argv){
    // does good when output double with no decimal part
    final BigDecimal doubleValWithoutDecimal = new BigDecimal(123.0);
    ObjectOutputUtility.console(doubleValWithoutDecimal.toString());
    // does no good when output double with decimal part
    final BigDecimal doubleValWithDecimal = new BigDecimal(123.1);
    ObjectOutputUtility.console(doubleValWithDecimal.toString());
    
    ObjectOutputUtility.console(String.valueOf(123.0));
    ObjectOutputUtility.console(String.valueOf(123.1));
    
    Double aDouble = new Double(123.0);
    ObjectOutputUtility.console(aDouble.floatValue());
  }
}
