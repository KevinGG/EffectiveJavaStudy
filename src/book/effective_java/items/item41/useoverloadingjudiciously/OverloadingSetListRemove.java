package book.effective_java.items.item41.useoverloadingjudiciously;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static utility.ObjectOutputUtility.outputCollectionToConsole;

public class OverloadingSetListRemove {
	public static void main(String[] argv){
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = -3; i < 3; i++){
			set.add(i);
			list.add(i);
		}
		for(int i=0; i< 3; i++){
			set.remove(i);
			list.remove((Integer)i);
		}
		
		outputCollectionToConsole(set);
		outputCollectionToConsole(list);
	}
}
