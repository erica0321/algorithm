class Solution {
    public String solution(String s) {
        int num = s.length();
        
        if (num % 2 == 0) {
            return s.substring(num / 2 - 1, num / 2 + 1);
        } else {
            return s.substring(num / 2, num / 2 + 1);
        }
    }
}
