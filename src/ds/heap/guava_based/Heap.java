package ds.heap.guava_based;

public interface Heap<T extends Comparable<T>> {
  public T peek();
  public void insert(T t);
  public T pop();
}


class Main{
  public static void main(String[] argv){
    Heap<Integer> heap = HeapGuavaBasedImpl.createMaxHeap();
    Heap<Integer> heap2 = HeapGuavaBasedImpl.createMinHeap();
    heap.insert(1); heap2.insert(3);
    heap.insert(2); heap2.insert(4);
    System.out.println(heap.pop());
    System.out.println(heap.pop());
    System.out.println(heap2.pop());
    System.out.println(heap2.pop());
  }
}
