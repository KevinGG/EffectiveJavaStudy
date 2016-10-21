package my.question.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Determine a strobogrammatic number, Like "69", "818".
 * A number rotate by 180 degree and still looks like itself
 * 
 * The following solution is dumb. Unnecessary recursion and too many boxed primitive type objects created during the process.
 * Simply use a 10-size int[] to hold the mapping and use 2 pointer to traverse the input String represented number.
 */
public class StrobogrammaticNumber {
	Helper helper = new Helper();
	
	public boolean determine(int n){
		String s = String.valueOf(n);
		return determine(s, 0, s.length()-1);
	}
	
	private boolean determine(String s, int i, int j){
		if(i > j) return true;
		if(i == j){ // 1 number in the middle
			if(helper.falseSet.contains(s.charAt(i))) return false;
			if(s.charAt(i) == '6' || s.charAt(i) == '9') return false;
			return true;
		}else {
			if(helper.falseSet.contains(s.charAt(i)) || helper.falseSet.contains(s.charAt(j))) return false;
			if(helper.trueMap.get(s.charAt(i)) == s.charAt(j)) return determine(s, i+1, j-1);
			return false;
		}
	}
	
	private static class Helper{
		Set<Character> falseSet = new HashSet<>();
		Map<Character, Character> trueMap = new HashMap<>();
		
		Helper(){
			falseSet.add('3');falseSet.add('4');falseSet.add('7');
			trueMap.put('0', '0');
			trueMap.put('1', '1');
			trueMap.put('2', '2');
			trueMap.put('5', '5');
			trueMap.put('6', '9');
			trueMap.put('8', '8');
			trueMap.put('9', '6');
		}
	}
	
	public static void main(String[] argv){
		System.out.println(new StrobogrammaticNumber().determine(106828901));
	}
}
