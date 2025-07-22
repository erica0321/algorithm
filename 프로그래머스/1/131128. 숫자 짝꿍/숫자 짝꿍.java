import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        for (char c : X.toCharArray()) xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        for (char c : Y.toCharArray()) yMap.put(c, yMap.getOrDefault(c, 0) + 1);

        List<Character> result = new ArrayList<>();
        for (char key : new HashSet<>(xMap.keySet())) {
            if (yMap.containsKey(key)) {
                int count = Math.min(xMap.get(key), yMap.get(key));
                for (int i = 0; i < count; i++) result.add(key);
            }
        }

        if (result.isEmpty()) return "-1";
        result.sort(Comparator.reverseOrder());
        
        if (result.get(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (char c : result) sb.append(c);

        return sb.toString();
    }
}
