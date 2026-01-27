class Solution {
    public int myAtoi(String s) {
        if(s==null||s.length()==0) return 0;

        int i=0;
        int n=s.length();

        while(i<n&&s.charAt(i)==' ')i++;

        if(i==n) return 0;
        int sign=1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // Build number with overflow check
        long num = 0;  // Use long to detect overflow safely
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;

            num = num * 10 + (c - '0');

            // Clamp early
            if (num > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        // Apply sign and cast to int (safe after check)
        return (int) (sign * num);
    
    }
}