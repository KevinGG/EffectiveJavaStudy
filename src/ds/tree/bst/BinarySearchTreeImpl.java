package ds.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

import ds.tree.NullNode;
import ds.tree.TreeNode;
import ds.tree.TreeNodeImpl;

public class BinarySearchTreeImpl<K extends Comparable<K>, T> implements BinarySearchTree<K, T> {
  private TreeNode<K, T> root = null;

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
  public void insert(TreeNode<K, T> n) {
    insert(root, n);
  }

  private void insert(TreeNode<K, T> position, TreeNode<K, T> n) {
    if (position == root && root == null) {
      root = n;
      return;
    }
    if (position.getKey().compareTo(n.getKey()) >= 0) {
      if (position.getLeft() == null) {
        n.setParent(position);
        position.setLeft(n);
        return;
      }
      insert(position.getLeft(), n);
    } else {
      if (position.getRight() == null) {
        n.setParent(position);
        position.setRight(n);
        return;
      }
      insert(position.getRight(), n);
    }
  }

  @Override
  public void delete(TreeNode<K, T> n) {
    if (n == null)
      return;
    delete(n.getKey());
  }

  @Override
  public void delete(K k) {
    delete(root, k);
  }

  private void delete(TreeNode<K, T> position, K k) {
    if (position == null)// cannot find the node with the key to be deleted
      return;

    if (position.getKey().compareTo(k) == 0) {
      TreeNode<K, T> parent = position.getParent();
      if (position.getLeft() == null && position.getRight() == null) {// no child
        if (parent == null) {// deleting root without children
          root = null;
        } else if (parent.getLeft() == position) {
          parent.setLeft(null);
        } else {
          parent.setRight(null);
        }
      } else if (position.getRight() == null) {// no right child
        if (parent == null) {// deleting root with only left child
          root = root.getLeft();
        } else if (parent.getLeft() == position) {
          parent.setLeft(position.getLeft());
        } else {
          parent.setRight(position.getLeft());
        }
      } else if (position.getLeft() == null) {// no left child
        if (parent == null) {// deleting root with only right child
          root = root.getRight();
        } else if (parent.getLeft() == position) {
          parent.setLeft(position.getRight());
        } else {
          parent.setRight(position.getRight());
        }
      } else { // both children
        TreeNode<K, T> successor = leftMostChildInSubTree(position.getRight());// get successor, successor shouldn't have left child for sure
        final TreeNode<K, T> replacedPosition =
            new TreeNodeImpl<>(successor.getKey(), successor.getValue());// deep copy a successor with only its key-value
        if (successor.getParent() == position) {// successor is the immediate right child
          if (successor.getRight() == null) { //successor has no child
            position.setRight(null);
          } else { // successor has only right child
            position.setRight(successor.getRight());
          }
        } else { // successor is a left child of some node on right sub tree
          if (successor.getRight() == null) { //successor has no child
            successor.getParent().setLeft(null);
          } else {
            successor.getParent().setLeft(successor.getRight());
          }
        }
        // deep copy children of position to copy of successor
        replacedPosition.setLeft(position.getLeft());
        replacedPosition.setRight(position.getRight());
        
        if (parent == null) {//deleting root with both children
          root = replacedPosition;
        } else if (parent.getLeft() == position) {
          parent.setLeft(replacedPosition);
        } else {
          parent.setRight(replacedPosition);
        }
      }
    } else if (position.getKey().compareTo(k) < 0) {
      delete(position.getRight(), k);
    } else {
      delete(position.getLeft(), k);
    }
  }

  private TreeNode<K, T> leftMostChildInSubTree(TreeNode<K, T> n) {
    if (n.getLeft() == null)
      return n;
    return leftMostChildInSubTree(n.getLeft());
  }

  @Override
  public void printTree() {
    System.out.println("===============print================");
    if (root == null) {
      System.out.println("null");
      System.out.println("================end=================");
      return;
    }
    @SuppressWarnings("unchecked")
    final TreeNode<K, T> nullNode = (TreeNode<K, T>) new NullNode<Integer, String>("null");
    final Queue<TreeNode<K, T>> currentLvl = new LinkedList<>();
    final Queue<TreeNode<K, T>> nextLvl = new LinkedList<>();
    boolean nextLvlAllNull = true;
    currentLvl.add(root);
    while (!currentLvl.isEmpty()) {
      TreeNode<K, T> node = currentLvl.remove();
      System.out.print(node + " ");
      if (node != nullNode) {
        if (node.getLeft() != null) {
          nextLvlAllNull = false;
          nextLvl.add(node.getLeft());
        } else {
          nextLvl.add(nullNode);
        }
        if (node.getRight() != null) {
          nextLvlAllNull = false;
          nextLvl.add(node.getRight());
        } else {
          nextLvl.add(nullNode);
        }
      }
      if (currentLvl.isEmpty()) {
        if (nextLvlAllNull)
          break;
        currentLvl.addAll(nextLvl);
        nextLvl.clear();
        nextLvlAllNull = true;
        System.out.println();
      }
    }
    System.out.println();
    System.out.println("================end=================");
  }
}
