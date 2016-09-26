package simpletests;

import java.util.Arrays;

public class PlayWithArray {
  public static void main(String[] argv){
    char[] c = "abcdefg".toCharArray();
    char[] copy = Arrays.copyOfRange(c, c.length, c.length);
    System.out.println(copy.length);
  }
}
