package algorithm.sort.generic;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueHeapSort {
  public <T extends Comparable<T>> void sort(T[] items){
    Queue<T> heap = new PriorityQueue<>();
    for(T t : items){
      heap.add(t);
    }
    for(int i = 0; i < items.length; ++i){
      items[i] = heap.remove();
    }
  }
}
