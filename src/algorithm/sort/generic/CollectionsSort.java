package algorithm.sort.generic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
  public static <T> List<T> sort(List<T> elements, Comparator<? super T> comparator){
    Collections.sort(elements, comparator);
    return elements;
  }
}
