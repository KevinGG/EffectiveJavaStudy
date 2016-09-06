package ds.tree.bst;

import ds.tree.TreeNode;

public class BinarySearchTreeImpl<K extends Comparable<K>, T>
    implements BinarySearchTree<K, T> {
  private TreeNode<K,T> root = null;

  @Override
  public TreeNode<K, T> search(K k) {
    return search(root, k);
  }

  private TreeNode<K, T> search(TreeNode<K, T> node, K k) {
    if (node == null)
      return null;
    if (node.getKey().compareTo(k) == 0)
      return node;
    if (node.getKey().compareTo(k) < 0)
      return search(node.getRight(), k);
    return search(node.getLeft(), k);
  }

  @Override
  public void insert(TreeNode<K,T> n) {
    insert(root, n);
  }

  private void insert(TreeNode<K,T> position, TreeNode<K,T> n) {
    if(position.getKey().compareTo(n.getKey()) >= 0){
      if (position.getLeft() == null) {
        position.setLeft(n);
        return;
      }
      insert(position.getLeft(), n);
    }else{
      if (position.getRight() == null) {
        position.setRight(n);
        return;
      }
      insert(position.getRight(), n);
    }
  }

  @Override
  public void delete(TreeNode<K,T> n) {
    // TODO Auto-generated method stub

  }
}
