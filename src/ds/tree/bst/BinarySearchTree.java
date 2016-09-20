package ds.tree.bst;

import ds.tree.TreeNode;

public interface BinarySearchTree<K extends Comparable<K>, T> {
  public TreeNode<K,T> search(K k);
  
  public void insert(TreeNode<K,T> n);
  
  public void delete(TreeNode<K,T> n);
  
  public void delete(K k);
  
  public void printTree();
}
