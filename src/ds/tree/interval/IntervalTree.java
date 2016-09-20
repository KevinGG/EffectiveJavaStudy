package ds.tree.interval;

import ds.interval.Interval;

public interface IntervalTree {
  public Interval findInterval(int point);
  public Interval findInterval(Interval interval);
  public void insertInterval();
  public void deleteInterval();
}
