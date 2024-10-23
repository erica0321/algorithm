class Solution {
    public static boolean[] visited;
    public static String[] words2;
    public static int result;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        words2 = words;
        
        dfs(begin, target, 0);
        
        return result;
    }
    
    public static void dfs(String begin, String target, int count) {
        if(begin.equals(target)) {
            result = count;
            return;
        }
        
        for(int i = 0; i < words2.length; i++) {
            if(!visited[i]) {
                int same = 0;
                for(int j = 0; j<words2[i].length(); j++) {
                    if(begin.charAt(j) == words2[i].charAt(j)) same ++;
                }
                
                if(same == begin.length() -1) {
                    visited[i] = true;
                    dfs(words2[i], target, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}