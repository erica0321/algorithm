

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;

        int[][] dp = new int[N][4];

        for(int i =0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i =1; i<N; i++) {
            dp[i][0] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][3];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<4; i++) {
            max = Math.max(dp[N-1][i], max);
        }
        return max;
    }
}