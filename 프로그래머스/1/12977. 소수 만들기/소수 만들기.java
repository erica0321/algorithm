import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (isPrime(temp)) answer += 1;
                }
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num == 2) return true;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
