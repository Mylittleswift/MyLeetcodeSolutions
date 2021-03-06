/**
*Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string 
containing only letters a-z or .. A . means it can represent any one letter.
For example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
*/

public class WordDictionary {
    Trie trie = new Trie(); 
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }
 
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
    
    class TrieNode {
        // Initialize your data structure here.
        boolean exist;
        char ch;
        TrieNode[] children;
        public TrieNode() {
            
        }
        public TrieNode(char ch) {
            this.ch = ch;
        }
    }
    
    class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode pre = root;
            for (int i = 0; i < word.length(); i++) {
                if (pre.children == null) {
                    pre.children = new TrieNode[26];
                }
                int index = word.charAt(i) - 'a';
                if (pre.children[index] == null) {
                    pre.children[index] = new TrieNode(word.charAt(i));
                }
                pre = pre.children[index];
                if (i == word.length() - 1) {
                    pre.exist = true;
                }
            }
        }
    
    
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            return recursiveSearch(word, 0, root);
        }
        
        public boolean recursiveSearch(String word, int index, TrieNode pre) {
            if (index == word.length()) {
                return pre.exist;
            }
            if (word.charAt(index) != '.') {
                int i = word.charAt(index)-'a';
                if (pre.children == null || pre.children[i] == null) {
                    return false;
                }
                return recursiveSearch(word, index + 1, pre.children[i]);
            } else {
                if (pre.children == null) {
                    return false;
                }
                for (int j = 0; j < 26; j++) {
                    if (pre.children[j] != null) {
                        if (recursiveSearch(word, index + 1, pre.children[j]) == true) {
                            return true;
                        } 
                    }
                }
                return false;
            }
        }
    }
}
