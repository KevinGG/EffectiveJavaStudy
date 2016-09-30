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
    
  }
  
  private boolean contains(String s, int idx){
    
  }
  
  private boolean find(String s){
    
  }

  @Override
  public void insert(String s) {
    
  }

  @Override
  public void delete(String s) {
    
  }
  
  private static final class TrieNode{
    Map<Character, TrieNode> map;
    boolean isEndOfString;
    
    TrieNode(){
      map = new HashMap<>();
      isEndOfString = false;
    }
  }

}
