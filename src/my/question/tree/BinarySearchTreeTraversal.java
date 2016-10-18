package my.question.tree;

import java.util.Stack;

/**
 * If findKthSmallest/Largest operation is needed frequently, and tree is mutable and frequently updated,
 * and k might be big
 * Store the result on each node, update those results when tree updated.
 * Thus to achieve logN time complexity for findKth operation. 
 */
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
  
  /**
   * Do this by in-order traverse, left -> parent -> right
   * This is just traversing all nodes from small to big
   * worst case this is linear search and tree is not balanced, O(n+k) = O(n)
   */
  public Node findKthSmallestNode(Node root, int k){
    if(root == null || k <= 0) return null;
    Stack<Node> stack = new Stack<>();
    Node p = root;
    Node result = null;
    while(!stack.empty() || p != null){
      if(p != null){
        stack.push(p);
        p = p.left;
      }else{ // no more left child
        p = stack.pop(); // get the parent of this null
        --k; // finally visited a node
        if(k == 0) {
          result = p;
          break;
        }
        p = p.right;
      }
    }
    return result;
  }
  
  /**
   * Do this by reversed in-order traverse, right -> parent -> left
   */
  public Node findKthLargestNode(Node root, int k){
    if(root == null || k <= 0) return null;
    Stack<Node> stack = new Stack<>();
    Node p = root;
    Node result = null;
    while(!stack.empty() || p != null){
      if(p != null){
        stack.push(p);
        p = p.right;
      }else{ // no more right child
        p = stack.pop(); // get the parent of this null
        --k;
        if(k == 0){
          result = p;
          break;
        }
        p = p.left;
      }
    }
    return result;
  }
  
  
  private static class Node{
    int val;
    Node left;
    Node right;
    Node(int x){val = x;}
  }
  
  public static void main(String[] argv){
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node root = n4;
    root.left = n2;
    n2.left = n1;
    n2.right = n3;
    root.right = n5;
    BinarySearchTreeTraversal bt = new BinarySearchTreeTraversal();
    System.out.println(bt.findBSTCommonAncestor(root, n3, n5).val);
    
    System.out.println(bt.findKthLargestNode(root, 5).val);
    System.out.println(bt.findKthSmallestNode(root, 5).val);
  }
}
