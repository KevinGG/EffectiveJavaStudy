package simpletests.algorithm.sort.nongeneric;

import java.util.Arrays;

import utility.TraversableUtil;

public class PlayWithArraySort {
  public static void main(String[] argv){
    int[] A = TraversableUtil.unsortedIntArray();
    Arrays.sort(A);
    System.out.println(Arrays.toString(A));
    
    for(int i = 0, j = A.length-1; i < j; ++i, --j){
      int tmp = A[j];
      A[j] = A[i];
      A[i] = tmp;
    }
    
    System.out.println(Arrays.toString(A));
  }
}
