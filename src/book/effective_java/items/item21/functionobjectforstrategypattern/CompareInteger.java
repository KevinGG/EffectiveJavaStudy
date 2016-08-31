package book.effective_java.items.item21.functionobjectforstrategypattern;

import static utility.ObjectOutputUtility.console;

public class CompareInteger {
	private static class IntegerComparator implements Comparator<Integer> {
		public int compare(Integer il, Integer ir) {
			return il.compareTo(ir);
		}
	}

	public static final Comparator<Integer> INTEGER_COMPARATOR = new IntegerComparator();
}

interface Comparator<T> {
	public int compare(Integer il, Integer ir);
}

class IntegerUtility {
	public static Integer findMaximumInteger(Integer... iList) {
		Integer result = null;
		for (Integer i : iList) {
			if (result == null) {
				result = i;
				continue;
			}
			result = biggerInteger(result, i, CompareInteger.INTEGER_COMPARATOR);
		}
		return result;
	}

	private static Integer biggerInteger(final Integer il, final Integer ir, final Comparator<Integer> comparator) {
		if (comparator.compare(il, ir) <= 0) {
			return ir;
		}
		return il;
	}
}

class MainMethod{
	public static void main(String[] argv) {
		console(IntegerUtility.findMaximumInteger(Integer.valueOf(20), Integer.valueOf(100), Integer.valueOf(50)));
	}
}