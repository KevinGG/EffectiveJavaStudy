package simpletests.algorithm.sort.nongeneric;

import static utility.ObjectOutputUtility.console;

import algorithm.sort.nongeneric.QuickSort;
import utility.TraversableUtil;

public class QuickSortMain {
  public static void main(String[] argv){
    console(new QuickSort().sort(TraversableUtil.unsortedIntArray()));
  }
}
