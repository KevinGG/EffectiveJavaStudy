package ds.interval;

import utility.HashCode;

public class Interval {
  private final int endLeft;
  private final int endRight;

  public int endLeft() {
    return endLeft;
  }

  public int endRight() {
    return endRight;
  }

  public Interval(final int endLeft, final int endRight) {
    if (endLeft > endRight) {
      throw new RuntimeException("Illegal interval creation: endLeft > endRight.");
    }
    this.endLeft = endLeft;
    this.endRight = endRight;
  }

  /**
   * Creates an {@link Interval} instance based on the given center point and radius, adjusted by the possible range for all generated instances.
   */
  public Interval(final int center, final int radius, final Interval range) {
    int left = center - radius;
    int right = center + radius;
    if (left < range.endLeft)
      left = range.endLeft;
    if (right > range.endRight)
      right = range.endRight;
    this.endLeft = left;
    this.endRight = right;
  }

  /**
   * Determines if 2 intervals overlap with each other.
   */
  public static boolean isOverLapped(final Interval i1, final Interval i2) {
    return !(i1.endLeft > i2.endRight || i1.endRight < i2.endLeft);
  }

  /**
   * Determines if current interval fully overlap (contain) the given interval.
   */
  public boolean contains(final Interval i) {
    return this.endLeft <= i.endLeft && this.endRight >= i.endRight;
  }

  /**
   * Merges 2 intervals to get an new interval
   * @param i1
   * @param i2
   * @return
   */
  public static Interval mergeIntervals(final Interval i1, final Interval i2) {
    if (i1 == i2)
      return i1;
    if (!isOverLapped(i1, i2)) {
      throw new RuntimeException("Cannot merge these 2 intervals, not overlapped");
    }
    final Interval mi =
        new Interval(Math.min(i1.endLeft, i2.endLeft), Math.max(i1.endRight, i2.endRight));
    if (mi.equals(i1))
      return i1;
    if (mi.equals(i2))
      return i2;
    return mi;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Interval))
      return false;
    Interval other = (Interval) o;
    if (other.endLeft == this.endLeft && other.endRight == this.endRight)
      return true;
    return false;
  }
  
  @Override
  public int hashCode(){
    return new HashCode<>(this).hashCode();
  }

  public void print() {
    System.out.println("[" + endLeft + ", " + endRight + "]");
  }

}
