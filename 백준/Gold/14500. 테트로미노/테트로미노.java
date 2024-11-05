import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M, answer;
  public static int[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

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
        visited[i][j] = true;
        dfs(j, i, 1, map[i][j]);
        visited[i][j] = false;
      }
    }
    System.out.println(answer);
  }

  public static void dfs(int x, int y, int count, int sum) {
    if (count == 4) {
      answer = Math.max(answer, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) continue;

      if (count == 2) {
        visited[ny][nx] = true;
        dfs(x, y, count + 1, sum + map[ny][nx]);
        visited[ny][nx] = false;
      }

      visited[ny][nx] = true;
      dfs(nx, ny, count + 1, sum + map[ny][nx]);
      visited[ny][nx] = false;
    }
  }
}
