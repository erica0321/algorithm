import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        s = s.replaceAll("\\{", "").replaceAll("\\}", "");
        String[] parts = s.split(",");
        
        for(String part : parts) {
            int partNum = Integer.parseInt(part);
            map.put(partNum, map.getOrDefault(partNum, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            result.add(entry.getKey());
        }

        return result;
        
    }
}