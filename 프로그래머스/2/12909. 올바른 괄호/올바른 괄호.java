import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> strStack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                strStack.push(ch);
            } else if (ch == ')') {
                if (strStack.isEmpty()) {
                    return false;
                }
                if (strStack.peek() == '(') {
                    strStack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return strStack.isEmpty();
    }
}
