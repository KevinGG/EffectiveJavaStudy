package simpletests.ds.heap;

import ds.heap.Heap;
import ds.heap.binaryheap.BinaryHeap;
import static utility.ObjectOutputUtility.console;
import utility.TraversableUtil;

public class Main_BinaryHeap {
  public static void main(String[] argv){
    Heap<Integer> heap = BinaryHeap.create();
    int[] A = TraversableUtil.unsortedIntArray();
    for(int i = 0; i < A.length; i++){
      heap.insert(A[i]);
    }
    while(heap.peek() != null){
      console(heap.pop() + ", ");
    }
  }
}
