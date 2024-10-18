import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M, answer;
  public static int[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  public static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
  public static boolean top;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          top = true;
          dfs(i, j);
          if (top) answer++;
        }
      }
    }

    System.out.println(answer);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

      if (map[nx][ny] > map[x][y]) {
        top = false;
      }

      if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
        dfs(nx, ny);
      }
    }
  }
}
