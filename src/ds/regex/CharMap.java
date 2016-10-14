package ds.regex;

import java.util.Set;

public class CharMap {
  private Set<Character> exclusionSet;
  private boolean isExclusive;
  
  private CharMap(){
    
    isExclusive = false;
  }
  
  private CharMap(final Set<Character> set, final boolean isExclusive){
    exclusionSet = set;
    this.isExclusive = isExclusive;
  }
}
