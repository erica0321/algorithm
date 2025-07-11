import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr= s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        String answer = "";
        for(String str : arr) {
            answer += str;
        }
        return answer;
    }
}