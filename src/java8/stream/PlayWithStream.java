package java8.stream;

import java.util.ConcurrentModificationException;
import java.util.List;

import utility.TraversableUtil;

public class PlayWithStream {
  public static void main(String[] argv) {
    List<Integer> list = TraversableUtil.unsortedIntegerList();
    System.out.println(list);

    // Using Iterable<T>.forEach(), following the iterator order, no ConcurrentModificationException
    // because setting is allowed as no structural modification
    list.forEach(i -> list.set(list.size() - 1, i));
    System.out.println(list);

    // Using Stream<T>.forEach(), arbitrary order but in this case the same sequential order as
    // iterator order, no ConcurrentModificationException because setting is allowed as no
    // structural modification
    list.stream().forEach(i -> list.set(list.size() - 1, i));
    System.out.println(list);

    try {
      list.forEach(i -> list.add(i));
    } catch (ConcurrentModificationException cme) {
      System.out.println("ConcurrentModificationException");
    }
  }
}
