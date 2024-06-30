class Solution {
    public int solution(int n, int k) {
        String change = Long.toString(n, k);
        
        String[] lists = change.split("0");
        
        int answer = 0;
        
        
        for (String list : lists) {
            if (list.isEmpty() || list.isBlank()) continue;
            
            long reverse = Long.parseLong(list);
            if (isPrime(reverse)) {
                     answer += 1;
            }
        }
        
        

        
        return answer;
    }
    
    public static boolean isPrime(long n) {
        if(n == 1) return false;
        if(n == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            } 
        }
        return true;
    }
}