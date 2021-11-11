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
        return node.dfs(node, word, 0);
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
        
        boolean dfs(Trie node, String word, int index) {
            if (index == word.length()) {
                return node.isEnd;
            }

            // the edge condition
            if (word.charAt(index) != '.') {
                //
                if (node.childNode[word.charAt(index) - 'a'] != null
                        && dfs(node.childNode[word.charAt(index) - 'a'], word, index+1)) {
                    return true;
                }
            } else {
                // node.allchild != null can dfs
                for (int i = 0; i < 26; i++) {
                    if (node.childNode[i] != null && dfs(node.childNode[i], word, index+1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    } 
}

