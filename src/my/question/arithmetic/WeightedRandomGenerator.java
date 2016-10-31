package my.question.arithmetic;

import java.util.Random;

public class WeightedRandomGenerator {
	private static final Random random = new Random();
	private int[][] numsWithFrequencies;
	private int[] range;
	
	public int pickOne(int[][] numsWithFrequencies){
		if(numsWithFrequencies == null || numsWithFrequencies.length == 0 || numsWithFrequencies[0].length == 0) throw new RuntimeException ("Invalid input");
		this.numsWithFrequencies = numsWithFrequencies;
		range = new int[numsWithFrequencies.length];
		range[0] = numsWithFrequencies[0][1]; // the exclusive ceil for a specific number
		for(int i = 1; i < numsWithFrequencies.length; ++i){
			range[i] = range[i-1] + numsWithFrequencies[i][1];
		}
		final int randomIndex = random.nextInt(range[range.length - 1]);
		System.out.println("random index: " + randomIndex);
		return locateNumber(randomIndex);
	}
	
	private int locateNumber(final int index){
		int i = 0, j = range.length-1;
		while(i < j){
			int mid = i + (j-i)/2;
			if(range[mid] <= index) i = mid+1;
			else j = mid;
		}
		return numsWithFrequencies[i][0];
	}
	
	public static void main(String[] argv){
		WeightedRandomGenerator wrg = new WeightedRandomGenerator();
		final int value = wrg.pickOne(new int[][]{{1,1}, {2,2}, {3,3}});
		System.out.println(value);
	}
}
