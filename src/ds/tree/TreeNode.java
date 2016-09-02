package ds.tree;

import ds.tree.bst.BinarySearchTree;
import ds.tree.bst.BinarySearchTreeImpl;

public interface TreeNode<T> {
  public <K extends Comparable<K>> K getKey();
  
  public T getValue();
}


class Main{
  public static void main(String[] argv){
    
    Integer key = 120;
    String value = "abc";
    //ABC abc = new ABC();
    TreeNode<String> tn = new TreeNodeImpl<String>(value){
      @SuppressWarnings("unchecked")
      @Override
      public Integer getKey() {
        return key;
      }
    };
    
    System.out.println(tn.getKey());
    
    BinarySearchTree<TreeNode<String>> bst = new BinarySearchTreeImpl<>();
    bst.search(key);
  }
  
//  private static final class ABC{
//  
//  }
}