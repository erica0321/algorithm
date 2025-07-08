import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        long[] arr = new long[str.length()];
        
        for(int i = 0; i < str.length(); i++) {
            arr[i] = Long.parseLong(String.valueOf(str.charAt(i)));
        }
        Arrays.sort(arr);
        
        String answer = "";
        for(int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i];
        }
        return Long.parseLong(answer);
    }
}
