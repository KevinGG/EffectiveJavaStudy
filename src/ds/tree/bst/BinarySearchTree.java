package ds.tree.bst;

import ds.tree.TreeNode;

public interface BinarySearchTree<N extends TreeNode<?>> {
  public <K extends Comparable<K>> N search(K k);
  
  public void insert(N t);
  
  public void delete(N t);
}
