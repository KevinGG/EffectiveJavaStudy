package my.question.arrays;

import static utility.ObjectOutputUtility.console;

import java.util.HashSet;
import java.util.Set;

public class CountHowManyNumsSmallerLater {
  public int[] countHowManayNumsSmallerLater(int[] nums){
    int[] result = new int[nums.length];
    Set<Integer> leftSmaller = new HashSet<>();
    Set<Integer> leftBigger = new HashSet<>();
    Set<Integer> rightAll = new HashSet<>();
    for(final int num : nums){
    	rightAll.add(num);
    }
    result[0] = nums[0] - 1;
    for(int i = 1; i < nums.length; i++){
    	if(nums[i-1] < nums[i]){
    		leftSmaller.add(nums[i-1]);
    		for(int j = nums[i-1]; j < nums[i]; j++){
    			if(leftBigger.contains(j)){
    				leftBigger.remove(j);
    				leftSmaller.add(j);
    			}
    		}
    	}else{
    		leftBigger.add(nums[i-1]);
    		for(int j = nums[i]; j < nums[i-1]; j++){
    			if(leftSmaller.contains(j)){
    				leftSmaller.remove(j);
    				leftBigger.add(j);
    			}
    		}
    	}
    	result[i] = nums[i] - 1 - leftSmaller.size();
    }
    return result;
  }
}


class Main{
	public static void main(String[] argv){
		console(new CountHowManyNumsSmallerLater().countHowManayNumsSmallerLater(new int[]{4,1,5,2,3}));
	}
}