package simpletests.ds.heap;

import ds.heap.Heap;
import ds.heap.guava_based.HeapGuavaBasedImpl;

public class Main{
  public static void main(String[] argv){
    Heap<Integer> heap = HeapGuavaBasedImpl.createMaxHeap();
    Heap<Integer> heap2 = HeapGuavaBasedImpl.createMinHeap();
    heap.insert(1); heap2.insert(3);
    heap.insert(2); heap2.insert(4);
    heap.insert(-1); heap2.insert(2);
    System.out.println(heap.pop());
    System.out.println(heap.pop());
    System.out.println(heap.pop());
    System.out.println(heap2.pop());
    System.out.println(heap2.pop());
    System.out.println(heap2.pop());
  }
}