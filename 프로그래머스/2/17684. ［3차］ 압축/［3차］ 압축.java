import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        // 사전 초기화
        for (int i = 0; i < 26; i++) {
            dict.add(Character.toString((char) ('A' + i)));
        }
        
        // 사전 추가하기
        for (int i = 0; i < msg.length(); i++) {
            // 가장 최근에 추가된 것(길이가 긴 것부터 확인)
            for (int j = dict.size() - 1; j >= 0; j--) {
                if (msg.substring(i).startsWith(dict.get(j))) {
                    i += dict.get(j).length() - 1;
                    result.add(j + 1);
                    if (i + 1 < msg.length()) {
                        dict.add(dict.get(j) + msg.charAt(i + 1));
                    }
                    break;
                }
            }            
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
