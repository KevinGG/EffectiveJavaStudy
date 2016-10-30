package my.question.arrays;

public class FindIndex {
	public int findIndexBiggerThanB4SmallerThanAfter(int[] nums){
		int max = 0;
		int result = 0;
		boolean found = true;
		for(int i = 1; i < nums.length; ++i){
			if(nums[i] > nums[max]) {
				if(!found) {
					found = true;
					result = i;
				}
				max = i;
				continue;
			}
			if(nums[result] >= nums[i]) {
				found = false;
			}
		}
		return found? result: -1;
	}
	
	public static void main(String[] argv){
		int r = new FindIndex().findIndexBiggerThanB4SmallerThanAfter(new int[]{1,2,3,2,1,4,5,6,7});
		System.out.println(r);
	}
}
