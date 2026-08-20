public class WordDictionary {

    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

   
    private boolean searchHelper(String word, int index, TrieNode current) {
        
        if (index == word.length()) {
            return current.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            
            for (TrieNode child : current.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            
            int childIndex = c - 'a';
            TrieNode node = current.children[childIndex];
            if (node == null) {
                return false;
            }
            return searchHelper(word, index + 1, node);
        }
    }
}