class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        
        for (int i = 1; i < n; i++) {
            res = getNext(res);
        }
        
        return res;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            int count = 1;
            char digit = s.charAt(i);
            
            // Move pointer and count consecutive identical digits
            while (i + 1 < s.length() && s.charAt(i + 1) == digit) {
                count++;
                i++;
            }
            
            // Append: [Count][Digit]
            sb.append(count).append(digit);
            i++;
        }
        
        return sb.toString();
    }
}