package simpletests.ds.tree.bit;

import ds.tree.binaryindexedtree.BinaryIndexedTree;

public class PlayWithBit {
	public static void main(String[] argv){
		BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{1,1,1,1,1,1,1,1}); // 8-length int[]
		System.out.println(bit.sum(7));
	}
}
