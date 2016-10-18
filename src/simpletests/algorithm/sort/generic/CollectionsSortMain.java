package simpletests.algorithm.sort.generic;

import static utility.ObjectOutputUtility.console;

import algorithm.sort.generic.CollectionsSort;
import utility.TraversableUtil;

public class CollectionsSortMain {
  public static void main(String[] argv){
    console(CollectionsSort.sort(TraversableUtil.unsortedIntegerList(), (i1, i2) -> i1.compareTo(i2)));
  }
}
