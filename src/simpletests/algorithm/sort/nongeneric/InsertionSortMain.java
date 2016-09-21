package simpletests.algorithm.sort.nongeneric;

import static utility.ObjectOutputUtility.console;

import algorithm.sort.nongeneric.InsertionSort;
import utility.TraversableUtil;

public class InsertionSortMain {
  public static void main(String[] argv){
    console(new InsertionSort().sort(TraversableUtil.unsortedIntArray()));
  }
}
