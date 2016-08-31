package book.effective_java.items.item5.avoidunnecessaryobjects;

import static utility.ObjectOutputUtility.outputInstanceToConsole;

public class StaticMethodOverConstructor {
	public static void main(String[] argv){
		String boolString = "FALSE";
		System.out.println("Use Boolean constructor to create 2 instances:");
		Boolean falseBooleanInstance1 = new Boolean(boolString);
		Boolean falseBooleanInstance2 = new Boolean(boolString);
		outputInstanceToConsole("falseBooleanInstance1", (Object)falseBooleanInstance1);
		outputInstanceToConsole("falseBooleanInstance2", (Object)falseBooleanInstance2);
		
		System.out.println();
		
		System.out.println("Use static factory method to create 2 instances:");
		Boolean falseBooleanInstance3 = Boolean.valueOf(boolString);
		Boolean falseBooleanInstance4 = Boolean.valueOf(boolString);
		outputInstanceToConsole("falseBooleanInstance3", (Object)falseBooleanInstance3);
		outputInstanceToConsole("falseBooleanInstance4", (Object)falseBooleanInstance4);
	}
}
