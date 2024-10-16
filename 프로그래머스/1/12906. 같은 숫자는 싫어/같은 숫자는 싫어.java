import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i =0; i<arr.length; i++) {
            if (stack.isEmpty() || stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];
        int i = stack.size()-1;
        
        while (!stack.isEmpty()) {
            int num2 = stack.pop();
            answer[i--] = num2;
        }
        
        return answer;
    }
}
