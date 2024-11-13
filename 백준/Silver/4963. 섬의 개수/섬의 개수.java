import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
  public static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
  public static boolean[][] visited;
  public static int[][] map;
  public static int h, w;
  public static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      if(w == 0 && h == 0) break;
      map = new int[h][w];

      for(int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      count = 0;
      visited = new boolean[h][w];
      for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
          if(!visited[i][j] && map[i][j] == 1) {
            count++;
            dfs(j, i);
          }
        }
      }
      System.out.println(count);
    }
  }

  public static void dfs(int x, int y) {
    visited[y][x] = true;
    for(int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= w || ny < 0 || ny >= h || visited[ny][nx] || map[ny][nx] == 0) continue;
      dfs(nx, ny);
    }
  }
}
