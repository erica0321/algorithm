class Solution {
    boolean solution(String s) {
        int p_num = 0;
        int y_num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) == 'p') p_num++;
            else if (Character.toLowerCase(s.charAt(i)) == 'y') y_num++;
        }
        
        return p_num == y_num;
    }
}
