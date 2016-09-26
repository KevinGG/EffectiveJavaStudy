package algorithm.sort.generic;

import ds.heap.Heap;
import ds.heap.binaryheap.BinaryHeap;

public class HeapSort {
  public <T extends Comparable<T>> void sort(T[] items){
    Heap<T> heap = BinaryHeap.create();
    for(T item : items){
      heap.insert(item);
    }
    for(int i = 0; i < items.length; i++){
      items[i] = heap.pop();
    }
  }
}
