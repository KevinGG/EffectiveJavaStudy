package java8.lambda;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class PlayWithLambda {
  public static void main(String[] argv){
    Function<String, Integer> length = (s) -> s.length();
    out.println(length.apply("abc"));
    
    ToIntFunction<Integer> negative = i -> -i;
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    list.sort(Comparator.comparingInt(negative));
    //list.sort(Collections.reverseOrder());
    Function<Integer, Integer> reverse = i -> -i;
    System.out.println(list);
  }
}
