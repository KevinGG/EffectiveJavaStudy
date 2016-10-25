package java8.stream;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import utility.TraversableUtil;

public class PlayWithStream {
  public static final String toString(Integer i) {
    return String.valueOf(i);
  }

  public static final Integer minus1(Integer i) {
    return i - 1;
  }

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

    Function<String, Boolean> function = s -> s.equals("5");

    // try map, filter and collect
    List<Integer> collectorList =
        list.stream().map(PlayWithStream::minus1).collect(Collectors.toList());
    System.out.println(collectorList);
    System.out.println("======================================================================");
    System.out.println(list.stream().map(PlayWithStream::toString).filter(s -> s.length() == 1)
        .map(function).collect(Collectors.toList()));

    // never do anything after following codes since the exceptions thrown by the statements are
    // suppressed by catch block, the current list's contents are unexpected
    // structural modifications, throw ConcurrentModificationException
    // However, the following codes will provide us with an understanding of how different iterating
    // mechanics iterate a given collection or stream
    try {
      list.forEach(i -> list.add(i));
    } catch (ConcurrentModificationException cme) {
      System.out.println("ConcurrentModificationException");
    }
    // if suppressing ConcurrentModificationException of Iterable<T>::forEach, the last element will
    // be successfully added
    System.out.println(list);

    try {
      list.stream().forEach(i -> list.add(i));
    } catch (ConcurrentModificationException cme) {
      System.out.println("ConcurrentModificationException");
    }
    // if suppressing ConcurrentModificationException of Stream<T>::forEach, the resulted list will
    // be [xx] if original list is [x].
    System.out.println(list);

    try {
      list.parallelStream().forEach(i -> list.add(i));
    } catch (ConcurrentModificationException cme) {
      System.out.println("ConcurrentModificationException");
    }
    // if suppressing ConcurrentModificationException of Stream<T>::forEach, the resulted list will
    // be [xx] if original list is [x].
    System.out.println(list);
  }
}
