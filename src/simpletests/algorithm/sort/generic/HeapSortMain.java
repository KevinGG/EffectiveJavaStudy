package simpletests.algorithm.sort.generic;

import algorithm.sort.generic.HeapSort;
import algorithm.sort.generic.PriorityQueueHeapSort;
import utility.ObjectOutputUtility;
import utility.TraversableUtil;

public class HeapSortMain {
  public static void main(String[] argv){
    Integer[] A = TraversableUtil.unsortedIntegerArray();
    new HeapSort().sort(A);
    ObjectOutputUtility.console(A);
    
    A = TraversableUtil.unsortedIntegerArray();
    new PriorityQueueHeapSort().sort(A);
    ObjectOutputUtility.console(A);
  }
}
