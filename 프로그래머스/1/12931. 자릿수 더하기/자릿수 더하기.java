import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = String.valueOf(n);
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}
