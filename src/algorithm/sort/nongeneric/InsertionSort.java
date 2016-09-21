package algorithm.sort.nongeneric;

import utility.Swapper;

public class InsertionSort {
  public int[] sort(int[] nums){
    if(nums == null || nums.length < 2) return nums;
    for(int i = 1; i < nums.length; i++){
      for(int j = i; j > 0; j--){
        if(nums[j] > nums[j-1]) break;
        Swapper.swap(nums, j, j-1);
      }
    }
    return nums;
  }
}
