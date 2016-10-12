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
    
  }
}
