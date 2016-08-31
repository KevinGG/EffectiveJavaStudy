package book.effective_java.items.item12.considercomparable;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;
import static utility.ObjectOutputUtility.*;

public class CollectionUsingEqualsOrCompareTo {
	public static void main(String[] argv) {
		BigDecimal BDV10SM1 = new BigDecimal("1.0");
		BigDecimal BDV100SM2 = new BigDecimal("1.00");
		
		console(BDV10SM1.compareTo(BDV100SM2));
		console(BDV10SM1.equals(BDV100SM2));
		
		HashSet<BigDecimal> bdHashSet = new HashSet<>();
		bdHashSet.add(BDV10SM1);
		bdHashSet.add(BDV100SM2);
		
		TreeSet<BigDecimal> bdTreeSet = new TreeSet<>();
		bdTreeSet.add(BDV10SM1);
		bdTreeSet.add(BDV100SM2);
		
		outputCollectionToConsole(bdHashSet);
		outputCollectionToConsole(bdTreeSet);
	}
}
