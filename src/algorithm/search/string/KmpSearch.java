package algorithm.search.string;

public class KmpSearch {
  public int search(String w, String s){
    if(w == null || s == null || w.length() == 0 || s.length() == 0 || w.length() > s.length()) return -1;
    if(w.length() == 1){
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == w.charAt(0)) return i;
      }
      return -1;
    }
    int[] T = computePartialMatchTable(w);
    int m = 0, i = 0;
    while(m + i < s.length()){
      if(w.charAt(i) == s.charAt(m+i)){
        if(i == w.length()-1) return m;
        ++i;
      }else{
        if(T[i] > -1){
          m = m + i - T[i];
          i = T[i];
        }else{
          m = m + i;
          i = 0;
        }
      }
    }
    return -1;
  }

  private int[] computePartialMatchTable(String w){
    int[] T = new int[w.length()];
    T[0] = -1;
    T[1] = 0;
    int pos = 2, i = 0;
    while(pos < w.length()){
      if(w.charAt(pos-1) == w.charAt(i)){
        T[pos] = i+1;
        ++i;
        ++pos;
      }else if (i > 0){
        i = T[i];
      }else{
        T[pos] = 0;
        ++pos;
      }
    }
    return T;
  }
}