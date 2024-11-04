import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int box = 1; box <= order.length; box++) {
            if (box == order[index]) {
                answer++;
                index++;
            } else {
                stack.push(box);
            }

            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
            }
        }

        return answer;
    }
}
