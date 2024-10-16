class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k; 
        int start = 0;
        
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= k + i; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            answer.append(max); 
        }
        
        return answer.toString();
    }
}
