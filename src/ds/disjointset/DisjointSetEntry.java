package ds.disjointset;

public class DisjointSetEntry<T> {
   DisjointSetEntry<T> parent;
   int rank;
   T t;
  
   public DisjointSetEntry(T t) {
     this.t= t;
     this.rank = 0;
     this.parent = this;
   }
   
   public void setParent(DisjointSetEntry<T> parent){
     this.parent = parent;
   }
  
   public DisjointSetEntry<T> getParent(){
     return parent;
   }
   
   public T getEntryValue(){
     return t;
   }
   
   public int getRank(){
     return rank;
   }
   
   public void updateRank(){
     rank++;
   }
}
