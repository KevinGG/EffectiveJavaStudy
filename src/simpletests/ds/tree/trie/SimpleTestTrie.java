package simpletests.ds.tree.trie;

import ds.tree.trie.Trie;
import ds.tree.trie.TrieImpl;

public class SimpleTestTrie {
	public static void main(String[] argv){
		Trie trie = new TrieImpl();
		System.out.println(trie.contains("abc"));
		trie.insert("abc");
		System.out.println(trie.contains("abc"));
		System.out.println(trie.contains("ab"));
		trie.delete("abc");
		System.out.println(trie.contains("abc"));
		trie.insert("abcd");
		System.out.println(trie.contains("abcd"));
		trie.insert("abc");
		System.out.println(trie.contains("abc"));
	}
}
