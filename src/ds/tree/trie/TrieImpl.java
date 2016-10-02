package ds.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImpl implements Trie{
  TrieNode root;
  
  public TrieImpl(){
    root = new TrieNode();
  }
  
  @Override
  public boolean contains(String s) {
    return root.contains(s, 0);
  }
  
  @Override
  public void insert(String s) {
    root.insert(s, 0);
  }

  @Override
  public void delete(String s) {
    root.delete(s, 0);
  }
  
  private static final class TrieNode{
    Map<Character, TrieNode> map;
    boolean isEndOfString;
    
    TrieNode(){
      map = new HashMap<>();
      isEndOfString = false;
    }
    
    boolean contains(String s, int i){
    		if(s == null || s.length() == 0 || i >= s.length()) return false;
    		if(map.containsKey(s.charAt(i))){
    			if(i == s.length() - 1){
    				if(isEndOfString) return true;
    				return false;
    			}
    			return map.get(s.charAt(i)).contains(s, i+1);
    		}
    		return false;
    }
    
    void insert(String s, int i){
    		if(s == null || s.length() == 0 || i >= s.length()) return;
    		if(map.containsKey(s.charAt(i))){
    			if(i == s.length() - 1){
    				isEndOfString = true;
    				return;
    			}
    			map.get(s.charAt(i)).insert(s, i+1);
    		}else{
    			final TrieNode n = new TrieNode();
    			map.put(s.charAt(i), n);
    			if(i == s.length() - 1){
    				isEndOfString = true;
    				return;
    			}
    			n.insert(s, i+1);
    		}
    }
    
    void delete(String s, int i){
    		if(s == null || s.length() == 0 || i >= s.length()) return;
    		if(map.containsKey(s.charAt(i))){
    			if(i == s.length() - 1){
    				isEndOfString = false;
    				return;
    			}
    			map.get(s.charAt(i)).delete(s, i+1);
    		}
    }
  }

}
