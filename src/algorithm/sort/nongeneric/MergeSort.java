package algorithm.sort.nongeneric;

import utility.ObjectOutputUtility;
import utility.TraversableUtil;

public class MergeSort {
  public void sort(int[] A){
    mergeSort(A, 0, A.length-1);
  }
  
  private void mergeSort(int[] A, int lo, int hi){
    if(lo == hi) return;
    int mid = lo + (hi - lo)/2;
    mergeSort(A, lo, mid);
    mergeSort(A, mid+1, hi);
    merge(A, lo, mid, hi);
  }
  
  private void merge(int[] A, int lo, int mid, int hi){
    int[] B = new int[hi-lo+1];
    int i = lo, j = mid+1, k = 0;
    for(; i <= mid && j <= hi; k++){
      if(A[i] < A[j]){
        B[k] = A[i];
        i++;
      }else{
        B[k] = A[j];
        j++;
      }
    }
    while(i <= mid){
      B[k] = A[i];
      i++;
      k++;
    }
    while(j <= hi){
      B[k] = A[j];
      j++;
      k++;
    }
    System.arraycopy(B, 0, A, lo, hi-lo+1);
  }
  
  public static void main(String[] argv){
    int[] A = TraversableUtil.unsortedIntArray();
    new MergeSort().sort(A);
    ObjectOutputUtility.console(A);
  }
}
