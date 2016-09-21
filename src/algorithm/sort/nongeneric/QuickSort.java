package algorithm.sort.nongeneric;

import static utility.ObjectOutputUtility.console;

import utility.Swapper;

public class QuickSort {
  public int[] sort(int[] nums){
    if(nums == null || nums.length < 2) return nums;
    quickSort(nums, 0, nums.length-1);
    return nums;
  }
  
  
  private void quickSort(int[] seq, int lo, int hi){
    if(lo < hi){
      int p = partition(seq, lo, hi);
      //console(p);
      //console(seq);
      quickSort(seq, lo, p-1);
      quickSort(seq, p+1, hi);
    }
  }
  
  private int partition(int[] seq, int lo, int hi){
      final int pivot = seq[hi];
      int p = lo;
      for(int i = lo; i < hi; i ++){
        if(seq[i] <= pivot){
          Swapper.swap(seq, p, i);
          p++;
        }
      }
      Swapper.swap(seq, p, hi);
      return p;
  }
}
