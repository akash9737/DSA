import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> list = new ArrayList<>();

        for (String word : words) {
            int r1 = 0, r2 = 0, r3 = 0;
            
            for (char ch : word.toLowerCase().toCharArray()) {
                if (row1.indexOf(ch) != -1) r1 = 1;
                else if (row2.indexOf(ch) != -1) r2 = 1;
                else if (row3.indexOf(ch) != -1) r3 = 1;
            }

            
            if (r1 + r2 + r3 == 1) {
                list.add(word);
            }
        }

        
        return list.toArray(new String[0]);
    }
}