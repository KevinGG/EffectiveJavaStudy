package simpletests.algorithm.search.string;

import algorithm.search.string.KmpSearch;

public class KmpSearchMain {
  public static void main(String[] argv){
    System.out.println(new KmpSearch().search("ab", "dcbadcbaaaaab"));
  }
}
