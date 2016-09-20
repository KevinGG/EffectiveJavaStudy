package simpletests.ds.tree.bst;

import ds.tree.TreeNode;
import ds.tree.TreeNodeImpl;
import ds.tree.bst.BinarySearchTree;
import ds.tree.bst.BinarySearchTreeImpl;

public class Main{
  public static void main(String[] argv){
    BinarySearchTree<Integer, String> bst = new BinarySearchTreeImpl<>();
    TreeNode<Integer, String> n1 = new TreeNodeImpl<>(20, "20");
    TreeNode<Integer, String> n2 = new TreeNodeImpl<>(15, "15");
    TreeNode<Integer, String> n3 = new TreeNodeImpl<>(25, "25");
    TreeNode<Integer, String> n4 = new TreeNodeImpl<>(10, "10");
    bst.insert(n1);
    //bst.printTree();
    bst.insert(n2);
    //bst.printTree();
    bst.insert(n3);
    //bst.printTree();
    bst.insert(n4);
    bst.printTree();
    bst.delete(20);
    bst.printTree();
    bst.delete(n3);
    bst.printTree();
  }
}
