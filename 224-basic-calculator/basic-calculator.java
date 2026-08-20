import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign); // Keeps track of signs across parenthesis scopes
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            } else if (c == '+' || c == '-') {
                ans += sign * num;
                // Update sign based on operator and current scope's sign from stack peek
                sign = (c == '+' ? 1 : -1) * stack.peek();
                num = 0;
            }
        }
        
        return ans + sign * num;
    }
}