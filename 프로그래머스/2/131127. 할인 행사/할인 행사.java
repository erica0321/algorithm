import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wanted = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wanted.put(want[i], number[i]);
        }

        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> list = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                list.put(discount[i + j], list.getOrDefault(discount[i + j], 0) + 1);
            }
            if (areMapsEqual(list, wanted)) {
                answer++;
            }
        }

        return answer;
    }
    
    public static <K, V> boolean areMapsEqual(HashMap<K, V> map1, HashMap<K, V> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (K key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                return false;
            }
            if (!map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }

        return true;
    }
}