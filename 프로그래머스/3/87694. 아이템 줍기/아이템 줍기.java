import java.util.*;

class Solution {
    public static int result;
    public static int[][] map = new int[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int y = y1 * 2; y <= y2 * 2; y++) {
                for (int x = x1 * 2; x <= x2 * 2; x++) {
                    if (map[y][x] == 1) continue;
                    map[y][x] = 1;
                    if (y == y1 * 2 || y == y2 * 2 || x == x1 * 2 || x == x2 * 2) {
                        map[y][x] = 2;  
                    }
                }
            }
        }

        result = 0;
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);  
        return result / 2; 
    }

    public static void bfs(int startX, int startY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); 
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == itemX && y == itemY) {
                result = dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && !visited[ny][nx] && map[ny][nx] == 2) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, dist + 1}); 
                }
            }
        }
        result = 0;
    }

}
