package simpletests.ds.disjointset;

import ds.disjointset.DisjointSetEntry;
import ds.disjointset.DisjointSet;

public class Main {
  //rank up only happens when 2 union sets having same rank, otherwise, larger rank wins
  public static void main(String[] argv){
    DisjointSetEntry<String> strA = new DisjointSetEntry<>("A");
    DisjointSetEntry<String> strB = new DisjointSetEntry<>("B");
    DisjointSetEntry<String> strC = new DisjointSetEntry<>("C");
    DisjointSetEntry<String> strD = new DisjointSetEntry<>("D");
    DisjointSetEntry<String> strE = new DisjointSetEntry<>("E");
    DisjointSetEntry<String> strF = new DisjointSetEntry<>("F");
    
    // A -> representative == A, rank 0
    System.out.println(DisjointSet.find(strA).getEntryValue());
    
    // A -> representative == B, rank up to 1
    DisjointSet.union(strB, strA);
    System.out.println(DisjointSet.find(strA).getEntryValue());

    // C -> representative == C, rank up to 1
    DisjointSet.union(strD, strC);
    System.out.println(DisjointSet.find(strC).getEntryValue());
    
    DisjointSet.union(strF, strE);// (F,E) represented by F, rank up to 1
    DisjointSet.union(strD, strE);// (C,D,E,F) represented by D, rank up to 2
    DisjointSet.union(strB, strC);// (A,B,C,D,E,F) represented by D, rank 2
    System.out.println(DisjointSet.find(strC).getEntryValue());
  }
}
