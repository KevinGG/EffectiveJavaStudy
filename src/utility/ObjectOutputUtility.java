package utility;

import java.util.Collection;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

public class ObjectOutputUtility {
	private ObjectOutputUtility() {
		throw new AssertionError();
	}
	
	public static void console(int[] nums){
	  console("[");
	  for(int i = 0; i < nums.length - 1; i ++){
	    console(nums[i]);
	    console(", ");
	  }
	  console(nums[nums.length - 1]);
	  consoleNl("]");
	}

	public static void outputInstanceToConsole(String objectName, Object object) {
		System.out.println(objectName + " is a " + object.getClass().getName() + " instance: "
				+ String.valueOf(object.hashCode()) + ", toString as: " + object.toString());
	}
	
	public static void outputCollectionToConsole(Collection<?> collection){
		int iterator = 0;
		System.out.println("=============================================================================");
		System.out.println("Collection<" + collection.getClass() + "> has " + collection.size() + " items.");
		for(Object object : collection){
			outputInstanceToConsole("Item["+String.valueOf(iterator)+"]", object);
			++iterator;
		}
		System.out.println("=============================================================================");
	}
	
	public static void console(int i){
	  System.out.print(i);
	}
	
	public static void console(Object object){
	    System.out.print(object.toString());
	}
	
	public static void consoleNl(Object object){
		System.out.println(object.toString());
	}
}
