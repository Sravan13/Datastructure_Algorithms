import java.util.HashMap;
import java.util.Map;


/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

public class Trie {

	TrieNode root;
	public static void main(String[] args) {
		
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}
	
	 /** Initialize your data structure here. */
    public Trie() {
        this.root =  new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(word.length() == 0) return;
    	
    	insert(word , root);
    }
    
    private void insert(String word , TrieNode root) {
    	
    	if(word.length() == 0) return;
    	
    	Map<Character, TrieNode> childsMap = root.getChildsMap();
		
		if(!childsMap.containsKey(word.charAt(0))) {
			
			TrieNode node =  new TrieNode(word.charAt(0));
			childsMap.put(word.charAt(0), node);   
			
			String subString = word.substring(1, word.length());
			
			if(!subString.isEmpty()) {
				node.setTerminal(false);
			}else {
				node.setTerminal(true);
			}
			
			insert(subString , node);
			
		}else {
			
			TrieNode node = childsMap.get(word.charAt(0));
			String subString = word.substring(1, word.length());
			
			if(subString.isEmpty()) {
				node.setTerminal(true);
			}
			
			insert(subString , node);
		}
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
    	return search(word, root);
        
    }
    
    private boolean search(String word, TrieNode root) {
    	
    	if(word==null || word.isEmpty()) return false;
    	Map<Character, TrieNode> childsMap = root.getChildsMap();
    	if(!childsMap.containsKey(word.charAt(0))) {
    		return false;
    	}else {  		
    		TrieNode node = childsMap.get(word.charAt(0));
    		
    		if(word.substring(1, word.length()).isEmpty() && node.isTerminal()) {
    			return true;
    		}else {
    			return search(word.substring(1, word.length()), node);
    		}
    	}
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    	return startsWith(prefix, root);
    }
    
    private boolean startsWith(String prefix, TrieNode root) {
    	
    	if(prefix == null || prefix.isEmpty()) return false;
    	
    	Map<Character, TrieNode> childsMap = root.getChildsMap();
    	if(!childsMap.containsKey(prefix.charAt(0))) {
    		return false;
    	}else {  		
    		TrieNode node = childsMap.get(prefix.charAt(0));
    		
    		if(prefix.substring(1, prefix.length()).isEmpty()) {
    			return true;
    		}else {
    			return startsWith(prefix.substring(1, prefix.length()), node);
    		}
    	}
    }
	
	
	class TrieNode {
		
		char character;
		Map<Character, TrieNode> map;
		boolean isTerminal;
		
		TrieNode(){
			map = new HashMap<Character, TrieNode>();
			isTerminal = false;
		}
		
		TrieNode(char character){
			this.character = character;
			map = new HashMap<Character, TrieNode>();
			isTerminal = false;
		}

		public char getCharacter() {
			return character;
		}

		public void setCharacter(char character) {
			this.character = character;
		}

		public Map<Character, TrieNode> getChildsMap() {
			return map;
		}

		public void setMap(Map<Character, TrieNode> map) {
			this.map = map;
		}

		public boolean isTerminal() {
			return isTerminal;
		}

		public void setTerminal(boolean isTerminal) {
			this.isTerminal = isTerminal;
		}
		
		
		
	}

}
