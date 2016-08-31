package book.effective_java.items.item13.minimizeaccessibility;

import static utility.ObjectOutputUtility.console;
import static utility.ObjectOutputUtility.outputCollectionToConsole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAlwaysMutable {
	private static final String[] PRIVATE_STRINGS = { "one", "two", "three" };
	
	public static final List<String>VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_STRINGS));
	
	public static final String[] values(){
		return PRIVATE_STRINGS.clone();
	}
}

class MainMethod {
	public static void main(String[] argv) {
		console("Fetched by combining Collection and Arrays API, the returned List is direct reference to the original array.");
		outputCollectionToConsole(ArrayAlwaysMutable.VALUES);
		try{
			ArrayAlwaysMutable.VALUES.set(0, "hacked");
		}catch(UnsupportedOperationException e){
			console("You cannot modify a unmodifiableList");
		}
		
		console("Fetched by array clone, the returned array is a completely different reference with same elements to the original array.");
		String[] clonedValues = ArrayAlwaysMutable.values();
		outputCollectionToConsole(Arrays.asList(clonedValues));
		clonedValues[0] = "hacked";
		outputCollectionToConsole(Arrays.asList(clonedValues));
		console("while the original array is still:");
		outputCollectionToConsole(ArrayAlwaysMutable.VALUES);
	}
}