class Solution {
    public int[] solution(int n, int m) {
        int num1 = gcd(n, m);
        int num2 = (n * m)/num1;
        
        return new int[]{num1, num2};
    }
    
    public int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
   }
}