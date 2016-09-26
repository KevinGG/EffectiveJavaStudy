package my.question.arithmetic;

import java.util.Random;

/**
 * Generate 1 with 1/(2^n) chance
 */
public class OneOfTwoToThePowerN {
	public int generateOneOrZero(final int n){
		if(n < 0) throw new RuntimeException("no such kind of probability!");
		if(n == 0) return 1;
		if(n < 31) return zeroWithN(n) ? 1 : 0;
		int loopCnt = n/30;
		int extra = n%30;
		if(zeroWithN(extra)){// passed extra
			for(int i = 0 ; i < loopCnt; i++){
				if(!zeroWithN(30)) return 0;
			}
			return 1;
		}
		return 0;
	}
	
	private boolean zeroWithN(int n){
		final int pool = (int)Math.pow(2, n);
		return new Random().nextInt(pool)%pool == 0;
	}
}

class Main{
	public static void main(String[] argv){
		System.out.println(new OneOfTwoToThePowerN().generateOneOrZero(100));
	}
}
