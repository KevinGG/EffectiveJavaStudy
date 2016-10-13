package my.question.arrays;

public class DetermineAscendingWithAtMost1Swap {
  public boolean isAscending(int[] nums){
    if(nums == null || nums.length == 0) return false;
    if(nums.length == 1) return true;
    int descCount = 0;
    int[] desc = new int[2];
    for(int i = 0; i < nums.length - 1; ++i){
      if(nums[i] == nums[i+1]) return false;
      if(nums[i] > nums[i+1]){
        if(descCount == 2) return false;
        desc[descCount] = i;
        ++descCount;
      }
    }
    if(descCount == 0) return true;
    int i = -1, j = -1;
    if(descCount == 1) {
    	i = desc[0];
    	j = desc[0]+1;
    	swap(nums, desc[0], desc[0]+1);
    }
    if(descCount == 2) {
    	i = desc[0];
    	j = desc[1]+1;
    	swap(nums, desc[0], desc[1]+1);
    }
    if(i > 0 && nums[i] < nums[i - 1]) return false;
    if(nums[i] > nums[i+1]) return false;
    if(j < nums.length - 1 && nums[j] > nums[j+1]) return false;
    if(nums[j] < nums[j - 1]) return false;
    return true;
  }
  
  private void swap(int[] nums, int i, int j){
	  int tmp = nums[i];
	  nums[i] = nums[j];
	  nums[j] = tmp;
  }
  
  public static void main(String[] argv){
	  System.out.println(new DetermineAscendingWithAtMost1Swap().isAscending(new int[]{1,5,3,4,2,6}));
  }
}
