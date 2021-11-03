package leetcode200;

public class Leetcode211 {
	Trie node;
	
    public Leetcode211() {
    	node = new Trie();
    }
    
    public void addWord(String word) {
    	node.insertWord(word);
    }
    
    public boolean search(String word) {
    	return node.findWord(word);
    }
    
    class Trie {
    	
    	Trie[] childNode;
    	boolean isEnd;
    	boolean isFind = false;
    	
    	Trie() {
    		childNode = new Trie[26];
    		isEnd = false;
    	}
    	
    	void insertWord(String word) {
    		Trie node = this;
    		for (int i = 0; i < word.length(); i++) {
    			int index = word.charAt(i) - 'a';
    			if (node.childNode[index] == null) {
    				node.childNode[index] = new Trie();
    			}
    			node = node.childNode[index];
    		}
    		node.isEnd = true;
    	}
    	
    	void dfs(Trie node, String word, int index) {
    		if (node == null) {
    			return;
    		}
    		
    		// the edge condition
    		if (node !=null && node.isEnd == true && index == word.length() && 
    				(word.charAt(index - 1) == '.' || node.childNode[word.charAt(index - 1) - 'a'] != null)) {
    			isFind = true;
    			return;
    		}
    		
    		for (Trie elem : node.childNode) {
				dfs(elem, word, index++);
				index--;   				
    		}
    	}
    	
    	boolean findWord(String word) {
    		dfs(this, word, 0);
    		return isFind;
    	}
    }
}

