package my.question.backtracking;

public class QueensPuzzle {
	int n;
	
	public static QueensPuzzle of(int n){
		if (n <= 3) throw new AssertionError("Invalid number of queens!");
		return new QueensPuzzle(n);
	}
	
	private QueensPuzzle(int n){
		this.n = n;
	}
	
	
}
