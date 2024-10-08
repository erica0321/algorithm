import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        //dp 저장할 곳
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i<triangle.length; i++) {
            // 맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j = 1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];   
            }
            
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        
        int max = dp[triangle.length-1][0];
        
        for(int i = 1; i<triangle.length; i++) {
            max = Math.max(max, dp[triangle.length-1][i]);
        }
        return max;
    }
}