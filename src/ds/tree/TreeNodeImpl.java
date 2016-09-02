package ds.tree;

public abstract class TreeNodeImpl<T> implements TreeNode<T> {
  private T t;
  
  public  TreeNodeImpl(T t){
    this.t = t;
  } 
  
  @Override
  public abstract <K extends Comparable<K>> K getKey();

  @Override
  public T getValue() {
    return t;
  }
}
