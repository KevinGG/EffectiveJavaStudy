package simpletests;

import ds.interval.Interval;

public class PlayWithHashCode {
//  @Override
//  public boolean equals(Object other){
//    if(this == other) return true;
//    if(!(other instanceof PlayWithHashCode)) return false;
//    PlayWithHashCode o = (PlayWithHashCode) other;
//    if(this.hashCode() == o.hashCode()) return true;
//    return false;
//  }
//  
//  @Override
//  public int hashCode(){
//    return 1;
//  }
  
  public static void main(String[] argv){
//    PlayWithHashCode p1 = new PlayWithHashCode();
//    PlayWithHashCode p2 = new PlayWithHashCode();
//    System.out.println(p1.hashCode() == p2.hashCode());
//    Object o2 = (Object) p2;
//    System.out.println(p1.hashCode() == p2.hashCode());
      Interval i1 = new Interval(1, 2);
      Interval i2 = new Interval(1, 2);
      System.out.println(i1.equals(i2));
      System.out.println(i1.hashCode() == i2.hashCode());
  }
}
