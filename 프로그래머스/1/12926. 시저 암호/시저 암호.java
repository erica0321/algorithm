class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                answer += ch;
                continue;
            }
            if (Character.isLowerCase(ch)) answer += (char)((ch + n - 'a') % 26 + 'a');
            else answer += (char)((ch + n - 'A') % 26 + 'A');            
        }
        return answer;
    }
}
