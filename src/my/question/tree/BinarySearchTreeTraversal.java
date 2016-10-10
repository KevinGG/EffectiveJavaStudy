package my.question.tree;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTreeTraversal {
  public Node findBSTCommonAncestor(Node root, Node p, Node q){
    if(root == null || p == null || q == null) return null;
    if(p.val > q.val) return findBSTCommonAncestor(root, q, p);
    if(root.val > q.val) return findBSTCommonAncestor(root.left, p, q);
    if(root.val < p.val) return findBSTCommonAncestor(root.right, p, q);
    //if p or q is not guaranteed to be in the tree, we need to search for p and q from the found "ancestor" until both are found.
    //if either of p and q is not in the tree, return null.
    return root;
  }
  
  public Node findKthSmallestNode(Node root, int k){
    Map<Node, Boolean> visited = new HashMap<>();
    
    return null;
  }
  
  private static class Node{
    int val;
    Node left;
    Node right;
    Node(int x){val = x;}
  }
}
