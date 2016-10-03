package my.question.arithmetic;

public class PlayWithLong {
	public static void main(String[] argv){
		long a = (long)Math.pow(2, 35);
		long b = a;
		System.out.println(a);
		a = a/3;
		System.out.println(a);
		b /= 3;
		System.out.println(b);
	}
}
