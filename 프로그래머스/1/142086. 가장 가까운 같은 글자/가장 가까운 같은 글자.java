import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (last.containsKey(ch)) {
                answer[i] = i - last.get(ch);
            } else {
                answer[i] = -1;
            }
            last.put(ch, i);
        }
        return answer;
    }
}
