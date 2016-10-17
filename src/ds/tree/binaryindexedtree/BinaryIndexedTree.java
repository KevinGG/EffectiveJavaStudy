package ds.tree.binaryindexedtree;

public class BinaryIndexedTree {
	int[] nums;
	int[] bit;
	
	public BinaryIndexedTree(int[] nums){
		this.nums = new int[nums.length];
		bit = new int[nums.length+1];
		for(int i = 0; i < nums.length; ++i){
			update(i, nums[i]);
		}
	}
	
	/*update nums index i with newNum*/
	public void update(int i, int newNum){
		int diff = newNum - nums[i];
		nums[i] = newNum;
		++i; // change to 1-based index in bit
		while(i < bit.length){
			bit[i] += diff;
			i += i & -i;
		}
	}
	
	/*calculate the sum of numbers from 0 to i in nums*/
	public int sum(int i){
		++i; // change to 1-based index in bit
		int sum = 0;
		while(i != 0){
			sum += bit[i];
			i -= i & -i;
		}
		return sum;
	}
}
