package ds.tree;

public class TreeNodeImpl<K extends Comparable<K>, T> implements TreeNode<K, T> {
  private K k;
  private T t;
  private TreeNode<K, T> left;
  private TreeNode<K, T> right;
  
  public  TreeNodeImpl(K k, T t){
    this.k = k;
    this.t = t;
  }
  
  @Override
  public K getKey(){
    return k;
  }

  @Override
  public T getValue() {
    return t;
  }

  @Override
  public TreeNode<K, T> getLeft() {
    return left;
  }

  @Override
  public TreeNode<K, T> getRight() {
    return right;
  }

  @Override
  public void setLeft(TreeNode<K, T> n) {
    left = n;
  }

  @Override
  public void setRight(TreeNode<K, T> n) {
    right = n;
  }
}
