package ds.regex;

import java.util.Map;
import java.util.Set;

public class RegexDictionary {
  private static final Character WILD = '*';
  private static final Character NON_EMPTY_WILD = '+';
  private Map<Character, Set<Character>> dictionary;
  
  public boolean isMap(Character regex, Character c){
    if(c == null){
      if(regex.equals(WILD)) return true;
      return false;
    }
    if(regex.equals(WILD) || regex.equals(NON_EMPTY_WILD)) return true;
    if(dictionary.containsKey(regex) && dictionary.get(regex)!=null && dictionary.get(regex).contains(c)) return true;
    if(regex.equals(c)) return true;
    return false;
  }
  
  public void updateDictionary(Character regex, Set<Character> mapSet){
    dictionary.put(regex, mapSet);
  }
}
