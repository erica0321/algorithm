import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                map.put(temp, Math.min(map.getOrDefault(temp, i + 1), i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String str = targets[i];
            for (int j = 0; j < str.length(); j++) {
                char key = str.charAt(j);
                if (map.containsKey(key)) answer[i] += map.get(key);
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
