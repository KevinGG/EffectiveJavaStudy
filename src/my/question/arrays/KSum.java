package my.question.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSum {
  private int[] nums;
  
  public Set<Set<Integer>> solv(int[] nums, int k, int target) {
    if (k < 2 || nums == null || nums.length < 2 || k > nums.length)
      return Collections.emptySet();
    Arrays.sort(nums);
    this.nums = nums;
    Set<Set<Integer>> result = new HashSet<>();
    result.addAll(dimDown(k, target, 0));
    return result;
  }
  
  private Set<Set<Integer>> dimDown(int k, int target, int start){
    Set<Set<Integer>> result = new HashSet<>();
    if (k == 2) {
      int i = start, j = nums.length - 1;
      while (i < j) {
        if (nums[i] + nums[j] == target) {
          Set<Integer> solution = new HashSet<>();
          if(!solution.add(i));
          solution.add(j);
          result.add(solution);
          // the following 2 steps ensure that a number would only be inside 1 solution, duplicate
          // numbers could cause duplicate solutions, but they can not create duplicate solutions by
          // cross combinations
          ++i;
          --j;
        } else if (nums[i] + nums[j] < target) {
          ++i;
        } else {
          --j;
        }
      }
    }else{
      for(int i = start; i <= nums.length - k; i++){
        Set<Set<Integer>> ddResult = dimDown(k-1, target-nums[i], i+1);
        for(Set<Integer> solution : ddResult){
          solution.add(i);
        }
        result.addAll(ddResult);
      }
    }
    return result;
  }
  
  public List<List<Integer>> translateResult(Set<Set<Integer>> result){
    List<List<Integer>> translated = new ArrayList<>();
    for(Set<Integer> solution: result){
      List<Integer> translatedSolution = new ArrayList<>();
      for(Integer i : solution){
        translatedSolution.add(nums[i]);
      }
      translated.add(translatedSolution);
    }
    return translated;
  }

  public static void main(String[] argv) {
    KSum kSum = new KSum();
    Set<Set<Integer>> result = kSum.solv(new int[] {1, 1, 2, 2, 3, 3, 4, 5}, 2, 6);
    System.out.println(result.toString());
    System.out.println("Corresponding to these numbers in nums array: ");
    System.out.println(kSum.translateResult(result));
  }
}
