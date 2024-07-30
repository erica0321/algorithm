import java.util.*;

class Solution {
    public static ArrayList<String> dict;
    public int solution(String word) {
        int answer = 0;
        String[] words = {"A", "E", "I", "O", "U"};
        dict = new ArrayList<>();
        dfs("", 0, words);
        
        for(int i = 0; i < dict.size(); i++) {
            if(dict.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String str, int length, String[] words) {
        dict.add(str);
        if(length == 5) return;
        for(int i = 0; i < 5; i++) {
            dfs(str + words[i], length+1, words);
        }
    }
}