package utility;

import java.util.ArrayList;
import java.util.Collection;

public class TestUtility {
	public static void main(String[] argv){
		final Collection<String> c = new ArrayList<String>(1);
		c.add("1");
		c.add("2");
		ObjectOutputUtility.outputCollectionToConsole(c);
	}
}
