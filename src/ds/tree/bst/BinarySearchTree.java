package ds.tree.bst;

import ds.tree.TreeNode;
import ds.tree.TreeNodeImpl;

public interface BinarySearchTree<K extends Comparable<K>, T> {
  public TreeNode<K,T> search(K k);
  
  public void insert(TreeNode<K,T> n);
  
  public void delete(TreeNode<K,T> n);
  
  public void delete(K k);
  
  public void printTree();
}


class Main{
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
  }
}
