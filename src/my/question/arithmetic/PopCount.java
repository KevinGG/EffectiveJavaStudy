package my.question.arithmetic;

public class PopCount {
	public int countBitsSet(int n){
		int count = 0;
		while(n != 0){
		     count += (n&1);
		     n >>>= 1;
		}
		return count;
	}
	
	public static void main(String[] argv){
		System.out.println(new PopCount().countBitsSet(-1));
	}
}
