package my.question.arithmetic;

public class HowManyBitsSet {
	public int bitsSet(int n){
		int count = 0;
		while(n!=0){
			n -= n & -n;
			++count;
		}
		return count;
	}
	
	public static void main(String[] argv){
		System.out.println(new HowManyBitsSet().bitsSet(0));
	}
}
