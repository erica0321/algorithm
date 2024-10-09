import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int[][] map;
  public static boolean[][] visited;
  public static int maxHeight = Integer.MIN_VALUE;
  public static int maxSafe = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, map[i][j]);
      }
    }

    for (int i = 0; i <= maxHeight; i++) {
      visited = new boolean[N][N];
      int safeAreaCount = 0;

      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (map[j][k] > i && !visited[j][k]) {
            dfs(j, k, i);
            safeAreaCount++;
          }
        }
      }
      maxSafe = Math.max(maxSafe, safeAreaCount);
    }
    System.out.println(maxSafe);
  }

  public static void dfs(int x, int y, int height) {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] > height) {
        dfs(nx, ny, height);
      }
    }
  }
}
