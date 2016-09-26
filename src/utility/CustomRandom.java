package utility;

import java.util.Random;

public class CustomRandom {
  private Random random = new Random();
  
  public boolean oneInTwo(){
    return oneIn(2);
  }
  
  public boolean oneIn(final int poolSize){
    return random.nextInt(poolSize) % poolSize == 0;
  }
}
