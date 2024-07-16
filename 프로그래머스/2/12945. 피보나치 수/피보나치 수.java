class Solution {
    public int solution(int n) {
        int answer = fibo(n);
        return answer % 1234567;
    }
    
    public int fibo(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        
        for(int i=2; i<=n; i++) {
            result[i] = (result[i-1] + result[i-2])%1234567;
        }
        return result[n];
    }
}