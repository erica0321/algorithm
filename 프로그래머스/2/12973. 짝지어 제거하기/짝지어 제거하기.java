import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> chStack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(!chStack.isEmpty()) {
                if(ch == chStack.peek()) {
                    chStack.pop();
                } else {
                    chStack.push(ch);
                }
            } else {
                chStack.push(ch);
            }
        }
        int answer = 0;
        
        if(chStack.isEmpty()) {
            answer = 1;
        } else {
            answer =0;
        }

        return answer;
    }
}