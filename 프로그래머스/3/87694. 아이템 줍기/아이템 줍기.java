import java.util.*;

class Solution {
    public static int[] start, end;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int answer = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        
        start = new int[]{characterX, characterY};
        end = new int[] {itemX, itemY};
        
        for (int[] rect : rectangle) {
            for (int i = rect[1] * 2; i <= rect[3] * 2; i++) {
                for (int j = rect[0] * 2; j <= rect[2] * 2; j++) {
                    if (map[i][j] == 2) continue;
                    map[i][j] = 2;
                    if (i == rect[1] * 2 || i == rect[3] * 2 || j == rect[0] * 2 || j == rect[2] * 2) map[i][j] = 1;
                }
            }
        }
        
        visited = new boolean[101][101];
        
        bfs(start[0] * 2, start[1] * 2, 0);
        
        return answer / 2;
    }
    
    public static void bfs(int x, int y, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, count});
        visited[y][x] = true;
        
       while(!queue.isEmpty()) {
           int[] cur = queue.poll();
           int cx = cur[0];
           int cy = cur[1];
           int length = cur[2];
           
           if(cx == end[0] *2 && cy == end[1]*2) {
               answer = length;
               return;
           }
           
           for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, length + 1}); 
                }
            }
       }
    }
}
