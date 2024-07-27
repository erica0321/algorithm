import java.util.ArrayList;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i = 0; list.size() <= p + (t - 1) * m; i++) {
            String str = Integer.toString(i, n).toUpperCase();
            for(int j = 0; j < str.length(); j++) {
                list.add(str.charAt(j));
            }
        }
        
        for(int i = 0; i < t; i++) {
            answer += list.get(p - 1 + i * m);
        }
        
        return answer;
    }
}
