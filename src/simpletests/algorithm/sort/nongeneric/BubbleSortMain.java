package simpletests.algorithm.sort.nongeneric;

import static utility.ObjectOutputUtility.console;

import algorithm.sort.nongeneric.BubbleSort;
import utility.TraversableUtil;

public class BubbleSortMain {
  public static void main(String[] argv){
    console(new BubbleSort().sort(TraversableUtil.unsortedIntArray()));
  }
}
