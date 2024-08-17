import java.util.*;

class Solution {
    static long people = 0;
    static int[] testTimes;
    
    public long solution(int n, int[] times) {
        testTimes = times;
        people = n;
        
        Arrays.sort(testTimes);
        
        long min = 1;
        long max = (long) testTimes[testTimes.length - 1] * n; 
        
        long answer = BSearch(min, max);
        return answer;
    }
    
    public static long BSearch(long min, long max) {
        long answer = max;
        while(min <= max) {
            long mid = (min + max) / 2;
            long possiblePeople = 0;
            
            for(int time : testTimes) {
                possiblePeople += mid / time;
            }
            
            if(possiblePeople >= people) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}