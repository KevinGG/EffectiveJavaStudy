package ds.tree.balancedtree;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
  private static Map<TreeNode, Integer> heightMap = new HashMap<>();
  
  public static boolean isBalanced(TreeNode root){
    if(root == null) return true;
    int hl= -1, hr = -1;
    if(root.left != null){
      hl = heightOf(root.left);
    }
    if(root.right != null){
      hr = heightOf(root.right);
    }
    return(Math.abs(hl-hr) < 2 && isBalanced(root.left) && isBalanced(root.right));
  }
  
  private static int heightOf(TreeNode node){
    if(node == null) return -1;
    if(heightMap.containsKey(node)){
      return heightMap.get(node);
    }
    int height = Math.max(heightOf(node.left), heightOf(node.right))+1;
    heightMap.put(node, height);
    return height;
  }
  
  private static final class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(final int val){
      this.val = val;
    }
  }
  
  public static void main(String[] argv){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    System.out.println(BalancedBinaryTree.isBalanced(root));
  }
}
