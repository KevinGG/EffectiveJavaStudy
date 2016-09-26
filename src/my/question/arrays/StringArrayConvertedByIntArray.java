package my.question.arrays;

import java.util.Arrays;

public class StringArrayConvertedByIntArray {
  public String[] findOriginalArray(final String[] str, final int[] it) {
    for (int j = 0; j < str.length; j++) {
      if(it[j] == -1) continue;
      int i = j; // first item in the linked list style array traversal
      int si = it[i]; // next item's index
      it[i] = -1; // null next of current
      String tmpStr = str[i]; // save the head
      while (si != j) { // back to the first item in this traversal and exit
        str[i] = str[si]; // put next to current position
        i = si; // current index becomes next's
        si = it[i]; // next become next.next
        it[i] = -1; // null next of current
      }
      str[i] = tmpStr; // put head to tail
      it[i] = -1; // null next
    }

    return str;
  }

  public static void main(String[] argv) {
    System.out.println(Arrays.asList(new StringArrayConvertedByIntArray()
        .findOriginalArray(new String[] {"dog", "cat", "mouse", "duck"}, new int[] {0,1,2,3})));
  }
}
