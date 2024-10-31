import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            answer.add(-1);
        }
        
        Stack<Integer> stack = new Stack<>(); 
        
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer.set(idx, numbers[i]);
            }
            stack.push(i);
        }
        
        return answer;
    }
}
