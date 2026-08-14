import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int start = i;
            int currentLength = words[i].length();
            i++;

            // Greedily pack words into the current line
            while (i < n && currentLength + 1 + words[i].length() <= maxWidth) {
                currentLength += 1 + words[i].length();
                i++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = i - start;
            int gaps = numberOfWords - 1;

            // Condition for Left-Justification:
            // 1. It is the last line (i == n)
            // 2. Or the line has only 1 word (gaps == 0)
            if (i == n || gaps == 0) {
                for (int j = start; j < i; j++) {
                    sb.append(words[j]);
                    if (j < i - 1) {
                        sb.append(" ");
                    }
                }
                // Pad remaining spaces on the right
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Condition for Fully-Justified Line (Middle Justification)
            else {
                // Total characters of words excluding the minimum mandatory single spaces
                int totalCharsLength = currentLength - gaps; 
                int totalSpacesNeeded = maxWidth - totalCharsLength;
                int spacesBetweenWords = totalSpacesNeeded / gaps;
                int extraSpaces = totalSpacesNeeded % gaps;

                for (int j = start; j < i; j++) {
                    sb.append(words[j]);
                    if (j < i - 1) {
                        // Base spaces + 1 extra space for the leftmost gaps
                        int spacesToApply = spacesBetweenWords + ((j - start) < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
        }

        return result;
    }
}