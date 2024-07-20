import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer>  map = new HashMap<>();
        
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        
        Collections.sort(valueList, Collections.reverseOrder());
        
        for (int value : valueList) {
            if (sum + value >= k) {
                answer++;
                break;
            } else {
                sum += value;
                answer++;
            }
        }
        
        return answer;
    }
}