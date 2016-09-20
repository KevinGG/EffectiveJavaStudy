package ds.disjointset;

public class DisjointSet{
  public static <T> DisjointSetEntry<T> find(DisjointSetEntry<T> t){
    if(t.getParent() != t) t.setParent(find(t.getParent()));
    return t.getParent();
  }
  
  public static <T> void union(DisjointSetEntry<T> x, DisjointSetEntry<T> y){
    DisjointSetEntry<T> rootX = find(x);
    DisjointSetEntry<T> rootY = find(y);
    
    if(rootX.getRank() > rootY.getRank()){
      rootY.setParent(rootX);
    }else if(rootX.getRank() < rootY.getRank()){
      rootX.setParent(rootY);
    }else{
      rootY.setParent(rootX);
      rootX.updateRank();
    }
  }
}

