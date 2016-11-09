package algorithm.search.array.binary;

import java.util.Arrays;
import java.util.List;

import utility.TraversableUtil;

public class BinarySearch<T extends Comparable<T>> {
    public int binarySearch(List<T> list, T key){
      if(list == null || list.isEmpty() || key == null) return -1;
      int bot = 0, top = list.size() - 1;
      int botCheck = list.get(bot).compareTo(key);
      int topCheck = list.get(top).compareTo(key);
      if(botCheck > 0 || topCheck < 0) return -1;
      if(botCheck == 0) return bot;
      if(topCheck == 1) return top;
      while(bot < top) {
        int mid = bot + (top - bot)/2;
        if(list.get(mid).compareTo(key) < 0) bot = mid + 1;
        else if(list.get(mid).compareTo(key) > 0) top = mid - 1;
        else return mid;
      }
      return -1;
    }
    
    public int binarySearch(int[] nums, int key){
    	if(nums == null || nums.length == 0) return -1;
    	int bot = 0, top = nums.length - 1;
    	if(nums[bot] > key || nums[top] < key) return -1;
    	if(nums[bot] == key) return bot;
    	if(nums[top] == key) return top;
    	while(bot < top){
    		int mid = bot + (top-bot)/2;
    		if(nums[mid] < key) bot = mid+1;
    		else if(nums[mid] > key) top = mid-1;
    		else return mid;
    	}
    	return -1;
    }
    
    public static void main(String[] argv){
    	int[] A = TraversableUtil.unsortedIntArray();
    	Arrays.sort(A);
    	System.out.println(Arrays.toString(A));
    	int result = new BinarySearch<Integer>().binarySearch(A, 18);
    	System.out.println(result);
    }
}
