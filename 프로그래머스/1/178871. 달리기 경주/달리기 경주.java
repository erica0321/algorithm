import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i =0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i =0; i<callings.length; i++) {
            int now = map.get(callings[i]);
            answer[now] = answer[now-1];
            answer[now-1] = callings[i];
            map.put(answer[now-1], now -1);
            map.put(answer[now], now);
        }
        
        return answer;
    }
}