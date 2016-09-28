package ds.heap;

public interface Heap<T extends Comparable<T>> {
  public T peek();
  
  public void insert(T t);
  
  public T pop();
  
  public int size();
  
  public enum HeapType{
    MIN_HEAP,
    MAX_HEAP;
  }
}
