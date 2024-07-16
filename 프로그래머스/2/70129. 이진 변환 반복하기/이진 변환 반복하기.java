class Solution {
    public int[] solution(String s) {
        int change = 0;
        int erase = 0;
        
        while (!s.equals("1")) {
            int zeroCount = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    zeroCount += 1;
                }
            }
            erase += zeroCount;
            
            s = s.replace("0", "");
            
            s = Integer.toBinaryString(s.length());
            change += 1;
        }
        
        int[] answer = {change, erase};
        return answer;
    }
}
