package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class TraversableUtil {
  private static final int[] UNSORTED_INT_ARRAY = new int[]{4,7,10,2,18,5,1};
  private static final ImmutableList<Integer> UNSORTED_INTEGER_ARRAY = ImmutableList.of(4,7,10,2,18,5,1);
  
  public static int[] unsortedIntArray(){
    return Arrays.copyOf(UNSORTED_INT_ARRAY, UNSORTED_INT_ARRAY.length);
  }
  
  public static List<Integer> unsortedIntegerList(){
    final ArrayList<Integer> copy = new ArrayList<>();
    copy.addAll(UNSORTED_INTEGER_ARRAY);
    return copy;
  }
}
