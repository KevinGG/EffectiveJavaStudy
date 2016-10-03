package my.question.arrays;

import java.util.Collection;
import java.util.Iterator;

import ds.heap.Heap;
import ds.heap.binaryheap.BinaryHeap;

public class ClosestStars {
  public Heap<Pair> find(Collection<Pair> c, int K){
    Iterator<Pair> itr = c.iterator();
    Heap<Pair> heap = BinaryHeap.create();
    while(itr.hasNext()){
      if(heap.size() < K){
        heap.insert(itr.next());
        continue;
      }
      Pair peek = heap.peek();
      Pair newPair = itr.next();
      if(peek.compareTo(newPair) > 0){
        heap.pop();
        heap.insert(newPair);
      }
    }
    return heap;
  }
  
  
  private static class Asserter{
    public void assertHeapsSame(Heap h1, Heap h2){
      if(h1 == h2) return;
      if(h1 == null || h2 == null) throw new RuntimeException("Null");
      if(h1.size() != h2.size()) throw new RuntimeException("Not same size");
      while(h1.size() > 0){
        if(h1.pop().compareTo(h2.pop()) != 0) throw new RuntimeException("Different items found");
      }
    }
  }
  
  private static class Pair implements Comparable<Pair>{
    long starId;
    long dist_from_earth;
    
    Pair(long starId, long dist_from_earth){
      this.starId = starId;
      this.dist_from_earth = dist_from_earth;
    }

    @Override
    public int compareTo(Pair o) {
      return (int) (this.dist_from_earth - o.dist_from_earth);
    }
  }
}
