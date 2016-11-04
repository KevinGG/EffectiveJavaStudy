package simpletests.algorithm.search.array;

import java.util.List;

import algorithm.search.array.binary.BinarySearch;
import utility.TraversableUtil;

public class PlayWithBinarySearchInArray {
  public static void main(String[] argv){
    BinarySearch<Integer> bs = new BinarySearch<>();
    List<Integer> list = TraversableUtil.unsortedIntegerList();
    System.out.println("Original List: " + list);
    list.sort((i1, i2) -> i1 - i2);
    System.out.println("Ascending Sorted List: " + list);
    System.out.println(bs.binarySearch(list, 1));
  }
}
