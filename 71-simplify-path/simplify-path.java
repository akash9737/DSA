import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        
        Deque<String> stack = new LinkedList<>();
        
        
        String[] components = path.split("/");
        
        for (String dir : components) {
            
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            
            else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir);
        }
        
        
        return result.length() > 0 ? result.toString() : "/";
    }
}