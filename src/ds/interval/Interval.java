package ds.interval;

public class Interval {
  public final int endLeft;
  public final int endRight;
  
  public Interval(final int endLeft, final int endRight){
    if(endLeft > endRight){
      throw new RuntimeException("Illegal interval creation: endLeft > endRight.");
    }
    this.endLeft = endLeft;
    this.endRight = endRight;
  }
  
  public static boolean isOverLapped(final Interval i1, final Interval i2){
    return !(i1.endLeft > i2.endRight || i1.endRight < i2.endLeft);
  }
  
  public static Interval mergeIntervals(final Interval i1, final Interval i2){
    if(i1 == i2) return i1;
    if(!isOverLapped(i1, i2)) {
      throw new RuntimeException("Cannot merge these 2 intervals, not overlapped");
    }
    return new Interval(Math.min(i1.endLeft, i2.endLeft), Math.max(i1.endRight, i2.endRight));
  }
}
