package java8.lambda;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class PlayWithLambda {
  public static int reverseOrder(Integer i) {
    return -i;
  }

  public static int naturalOrder(Integer i) {
    return i;
  }

  public static int reverseOrderFromInt(int i) {
    return -i;
  }

  public static int length(String s) {
    return s.length();
  }

  public static void main(String[] argv) {
    // a Function interface of input type String and output type Integer,
    // implemented with lambda expression, return a String's length
    Function<String, Integer> length = (s) -> s.length();
    // apply length function to "abc" String, return "abc"'s length
    out.println(length.apply("abc"));

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 100);

    // a Function interface of input type Integer and output type primitive int
    Function<Integer, Integer> negativeFromIntegerToInteger = i -> -i;
    ToIntFunction<Integer> negativeFromIntegerToInt = i -> -i;
    IntFunction<Integer> negativeFromIntToInteger = i -> -i;
    IntUnaryOperator negativeFromIntToInt = i -> -i;

    list.sort(Comparator.comparing(negativeFromIntegerToInteger));
    list.sort(Comparator.comparingInt(negativeFromIntegerToInt));
    // all from int Function cannot be used here, compile error
    // list.sort(Comparator.comparing(negativeFromIntToInteger));
    // list.sort(Comparator.comparingInt(negativeFromIntToInt));

    list.sort(Comparator.comparing(PlayWithLambda::reverseOrder));
    out.println(list);

    list.sort(Comparator.comparing(PlayWithLambda::naturalOrder));
    out.println(list);

    // if using method reference, the input type and output type could both be primitive
    list.sort(Comparator.comparing(PlayWithLambda::reverseOrderFromInt));
    out.println(list);
    
    list.sort((i1, i2)->i1-i2);
    out.println(list);

    // the comparator is for String not int, so compile error
    // list.sort(Comparator.comparing(PlayWithLambda::length));
    
    // sort by int String representation length
    System.out.println(list.stream().map(i -> String.valueOf(i))
        .sorted(Comparator.comparingInt(PlayWithLambda::length)).collect(Collectors.toList()));
    
    // reversed sort by int String representation length
    System.out.println(list.stream().map(i -> String.valueOf(i))
        .sorted(Comparator.comparingInt(PlayWithLambda::length).reversed()).collect(Collectors.toList()));
  }
}
