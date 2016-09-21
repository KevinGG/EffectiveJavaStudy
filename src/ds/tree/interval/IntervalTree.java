package ds.tree.interval;

import java.util.List;

import ds.interval.Interval;

public interface IntervalTree {
  public List<Interval> findInterval(int point);
  public List<Interval> findInterval(Interval interval);
  public void insertInterval(Interval interval);
  public void deleteInterval();
}
