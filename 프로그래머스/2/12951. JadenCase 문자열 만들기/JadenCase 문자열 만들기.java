class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        String answer = "";
        
        for (String word : str) {
            word = word.toLowerCase();
            if(word.length() == 0) {
                answer += " ";
            }
            if (word.length() > 0) {
                word = word.trim();
                answer += (word.substring(0, 1)).toUpperCase() + (word.substring(1))  + " ";
            } 
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        
        // 마지막에 추가된 공백을 제거
        return answer.trim();
    }
}
