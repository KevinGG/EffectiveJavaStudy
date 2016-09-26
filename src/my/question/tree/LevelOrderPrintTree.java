package my.question.tree;

import ds.tree.TreeNode;
import ds.tree.TreeNodeImpl;
import ds.tree.bst.BinarySearchTreeImpl;

public class LevelOrderPrintTree {
	public static void main(String[] argv){
	    BinarySearchTreeImpl<Integer, String> bst = new BinarySearchTreeImpl<>();
	    TreeNode<Integer, String> n1 = new TreeNodeImpl<>(20, "20");
	    TreeNode<Integer, String> n2 = new TreeNodeImpl<>(15, "15");
	    TreeNode<Integer, String> n3 = new TreeNodeImpl<>(25, "25");
	    TreeNode<Integer, String> n4 = new TreeNodeImpl<>(10, "10");
	    TreeNode<Integer, String> n5 = new TreeNodeImpl<>(7, "7");
	    TreeNode<Integer, String> n6 = new TreeNodeImpl<>(12, "12");
	    TreeNode<Integer, String> n7 = new TreeNodeImpl<>(1, "1");
	    TreeNode<Integer, String> n8 = new TreeNodeImpl<>(8, "8");
	    
	    
	    bst.insert(n1);
	    bst.insert(n2);
	    bst.insert(n3);
	    bst.insert(n4);
	    bst.insert(n5);
	    bst.insert(n6);
	    bst.insert(n7);
	    bst.insert(n8);
	    
	    bst.printTreeInLevelOrder();
	  }
	
}
