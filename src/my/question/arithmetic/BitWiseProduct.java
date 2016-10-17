package my.question.arithmetic;

/**
 * Calculate product of 2 positive number with bit manipulation and +/-
 */
public class BitWiseProduct {

	/*
	 * The following implementation uses Integer.toBinaryString(int a), so slow
	 */
	public int calculate(int a, int b) {
		String s = Integer.toBinaryString(a);
		int L = s.length();
		int result = 0;
		for (int i = 0; i < L; i++) {
			if (s.charAt(i) == '1') {
				result += b << (L - 1 - i);
			}
		}
		return result;
	}

	public int product(int a, int b) {
		int product = 0, shift = 0;
		if (b > a) { // always use smaller number for bit manipulation to save time
			int tmp = b;
			b = a;
			a = tmp;
		}
		while (b > 0) {
			if ((b & 1) == 1)
				product += a << shift;
			++shift;
			b >>= 1; // >> since we know a,b are positive
		}
		return product;
	}

	public static void main(String[] argv) {
		System.out.println(new BitWiseProduct().product(3, 15));
	}
}
