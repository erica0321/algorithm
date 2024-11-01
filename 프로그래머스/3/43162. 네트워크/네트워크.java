import java.util.*;

class Solution {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i =0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        
        int answer =0;
        
        for(int i =0; i<n; i++) {
            if(!visited[i]) {
                answer ++;
                dfs(i);
            }
        }
        return answer;
    }
    public static void dfs(int node) {
        for(int v: list[node]) {
            if(!visited[v]) {
                visited[v] = true;
                dfs(v);
            }
        }
    }
}