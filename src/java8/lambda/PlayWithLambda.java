package java8.lambda;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PlayWithLambda {
  public static void main(String[] argv){
    Function<String, Integer> length = (s) -> s.length();
    out.println(length.apply("abc"));
    
    Function<Integer, Integer> negative = i -> -i;
    List<Integer> list = Arrays.asList(6,5,4,3,2,1);
    list.sort(Comparator.comparingInt(negative));
    System.out.println(list);
  }
}
