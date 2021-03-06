package ds.tree;

public interface TreeNode<K extends Comparable<K>, T> {
  public K getKey();
  
  public T getValue();
  
  public TreeNode<K, T> getLeft();
  
  public TreeNode<K, T> getRight();
  
  public TreeNode<K, T> getParent();
  
  public void setLeft(TreeNode<K, T> n);
  
  public void setRight(TreeNode<K, T> n);
  
  public void setParent(TreeNode<K, T> n);
}