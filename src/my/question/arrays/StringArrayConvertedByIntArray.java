package my.question.arrays;

import java.util.Arrays;

public class StringArrayConvertedByIntArray {
	public String[] findOriginalArray(final String[] str, final int[] it) {
		// corner

		int i = 0;
		int si = it[i];
		String tmpStr = str[0];
		while (si != 0) {
			str[i] = str[si];
			i = si;
			si = it[i];
		}
		str[i] = tmpStr;

		return str;
	}

	public static void main(String[] argv) {
		System.out.println(Arrays.asList(new StringArrayConvertedByIntArray()
				.findOriginalArray(new String[] { "dog", "cat", "mouse", "duck" }, new int[] { 2, 0, 1, 3})));
	}
}
