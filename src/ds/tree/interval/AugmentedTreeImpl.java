package ds.tree.interval;

import java.util.LinkedList;
import java.util.List;

import ds.interval.Interval;

public class AugmentedTreeImpl implements IntervalTree{
  AugmentedTreeNode root;
  
  public AugmentedTreeImpl() {
    root = null;
  }
  
  @Override
  public List<Interval> findInterval(int point) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Interval> findInterval(Interval interval) {
    List<Interval> result = new LinkedList<>();
    findInterval(root, interval, result);
    return result;
  }
  
  private void findInterval(AugmentedTreeNode node, Interval interval, List<Interval> result){
  }

  @Override
  public void insertInterval(Interval interval) {
    if(root == null){
      root = new AugmentedTreeNode(interval);
      return;
    }
    
  }

  @Override
  public void deleteInterval() {
    // TODO Auto-generated method stub
    
  }
  
  private static class AugmentedTreeNode{
    private int top;
    private Interval interval;
    private AugmentedTreeNode left;
    private AugmentedTreeNode right;
    
    private AugmentedTreeNode(final Interval interval){
      this.interval = interval;
      this.top = interval.endRight();
      this.left = null;
      this.right = null;
    }
    
    private void updateTop(final int top){
      this.top = top;
    }
  }
}
