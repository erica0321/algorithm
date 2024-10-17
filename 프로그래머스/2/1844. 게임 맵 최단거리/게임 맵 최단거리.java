import java.util.*;

class Solution {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] visited;
    public static int[][] arr; 
    public int solution(int[][] maps) {
        arr = maps;
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        bfs(0, 0);
        
        answer = visited[maps.length-1][maps[0].length -1];
        if(answer == 0) return -1;
        
        return answer;
    }
    
    public static void bfs(int startX, int startY) {
        visited[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] current =queue.poll();
            int cX = current[0];
            int cY = current[1];
            
            for(int i =0; i<4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                if(nX < 0 || nX >= arr.length || nY < 0 || nY >= arr[0].length) {
                    continue;
                }
                if(visited[nX][nY] == 0 && arr[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[] {nX, nY});
                }
            }
        }
        
    }
}