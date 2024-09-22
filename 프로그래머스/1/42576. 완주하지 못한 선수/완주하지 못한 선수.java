import java.util.HashMap;

class Solution {
    public String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }
        
        for (String completion : completions) {
            map.put(completion, map.get(completion) - 1);
        }
        
        for (String participant : participants) {
            if (map.get(participant) > 0) {
                return participant;
            }
        }
        
        return "";  
    }
}
