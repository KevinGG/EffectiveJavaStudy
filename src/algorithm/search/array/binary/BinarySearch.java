package algorithm.search.array.binary;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    public int binarySearch(List<T> list, T key){
      if(list == null || list.isEmpty() || key == null) return -1;
      int bot = 0, top = list.size() - 1;
      int botCheck = list.get(bot).compareTo(key);
      int topCheck = list.get(top).compareTo(key);
      if(botCheck > 0 || topCheck < 0) return -1;
      if(botCheck == 0) return bot;
      if(topCheck == 1) return top;
      while(bot < top) {
        int mid = bot + (top - bot)/2;
        if(list.get(mid).compareTo(key) < 0) bot = mid + 1;
        else if(list.get(mid).compareTo(key) > 0) top = mid - 1;
        else return mid;
      }
      return -1;
    }
}
