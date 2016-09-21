package algorithm.sort.nongeneric;

import utility.Swapper;

public class BubbleSort {
  public int[] sort(int[] nums){
    if(nums == null || nums.length < 2) return nums;
    boolean swapped;
    int L = nums.length;
    while(true){
      swapped = false;
      for(int i = 0; i < L-1; i++){
        if(nums[i] > nums[i+1]){
          Swapper.swap(nums, i, i+1);
          swapped = true;
        }
      }
      L--;
      if(!swapped) break;
    }
    return nums;
  }
}
