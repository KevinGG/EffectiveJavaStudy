package my.question.arrays;

public class BiggestIntAfterReconstruction {
	public int recon(int num){
		if(num/10 == 0 || num == Integer.MAX_VALUE) return num;
		int[] count = new int[10];
		int result = 0;
		int digitNum = 0;
		while(num > 0){
			++count[num%10];
			num /= 10;
			++digitNum;
		}
		//2147483647
		if(digitNum == 10){
			int[] tenDigitConstraint = new int[]{2,1,4,7,4,8,3,6,4,7};
			for(int i = 0; i < 10; ++i){
				int digit = tenDigitConstraint[i];
				for(; digit >= 0; --digit){
					if(count[digit] > 0){
						result = result*10 + digit;
						--count[digit];
						break;
					}
				}
				if(digit == tenDigitConstraint[i]) continue;
				else break;
			}
		}
		for(int digit = 9; digit >= 0; --digit){
			for(int i = 0; i < count[digit]; ++i){
				result = result*10 + digit;
			}
		}
		return result;
	}
	
	public static void main(String[] argv){
		System.out.println(new BiggestIntAfterReconstruction().recon(2123456789));
	}
}
