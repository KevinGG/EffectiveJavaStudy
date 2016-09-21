package my.question.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ds.interval.Interval;

public class RainDrop {
  private List<Interval> wet = new ArrayList<>();
  
  public void determineFullyWet(){
    int count = 0;
    while(!isFullyWet()){
      final Interval i = RainDropGenerator.nextRainDrop();
      i.print();
      merge(i);
      count++;
    }
    System.out.println("Fully wet after " + count + " raindrops.");
  }
  
  // This is inserting a interval into the list of intervals (wet). But in this case, the inserted interval will at most intersect with 2 intervals.
  private void merge(Interval i){
    int count = 0;
    List<Interval> newWet = new ArrayList<>();
    Interval mi = i;
    for(Interval j : wet){
      if(count == 2) break;
      if(!Interval.isOverLapped(i, j)){
        newWet.add(j);
      }else{
        mi = Interval.mergeIntervals(mi, j);
        count++;
      }
    }
    newWet.add(mi);
    wet = newWet;
  }
  
  private boolean isFullyWet(){
    if(wet.size() == 1 && wet.get(0).equals(RainDropGenerator.range)) return true;
    return false;
  }
  

  private static class RainDropGenerator{
    private static Random random = new Random();
    private static Interval range = new Interval(0, 100);
    
    private static Interval nextRainDrop(){
      return new Interval(random.nextInt(101), 1, range);
    }
  }
}

class Main{
  public static void main(String[] argv){
    new RainDrop().determineFullyWet();
  }
}


