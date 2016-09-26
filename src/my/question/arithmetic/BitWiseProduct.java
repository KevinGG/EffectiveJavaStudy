package my.question.arithmetic;

/**
 * Calculate product of 2 positive number with bit manipulation and +/-
 */
public class BitWiseProduct {
	public int calculate(int a, int b){
		String s = Integer.toBinaryString(a);
		int L = s.length();
		int result = 0;
		for(int i = 0; i < L; i++){
			if(s.charAt(i) == '1'){
				result += b << (L-1-i);
			}
		}
		return result;
	}
	
	public static void main(String[] argv){
		System.out.println(new BitWiseProduct().calculate(20, 16));
	}
}

