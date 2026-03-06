import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int n = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();

        // 1. Build the frequency map for the words
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 2. Iterate through wordLen possible starting offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            for (int j = i; j <= n - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If a word frequency exceeds the limit, shift the left pointer
                    while (currentMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Found a valid concatenation
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Word not in our list: Reset the window
                    currentMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return result;
    }
}