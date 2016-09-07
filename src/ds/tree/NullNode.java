package ds.tree;

public class NullNode<K extends Comparable<K>, T> implements TreeNode<K, T>{
  private T t;
  
  public NullNode(T t){
    this.t= t;
  }
  
  @Override
  public K getKey() {
    return null;
  }

  @Override
  public T getValue() {
    return t;
  }

  @Override
  public TreeNode<K, T> getLeft() {
    return null;
  }

  @Override
  public TreeNode<K, T> getRight() {
    return null;
  }

  @Override
  public TreeNode<K, T> getParent() {
    return null;
  }

  @Override
  public void setLeft(TreeNode<K, T> n) {
  }

  @Override
  public void setRight(TreeNode<K, T> n) {
  }

  @Override
  public void setParent(TreeNode<K, T> n) {
  }
  
  @Override
  public String toString(){
    return t.toString();
  }

}
