import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int[][] map;
  public static boolean[][] visited;
  public static int max = 0;
  public static int count = 0;
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
        if (!visited[i][j] && map[i][j] == 1) {
          count++;
          int size = dfs(i, j);
          max = Math.max(max, size);
        }
      }
    }

    System.out.println(count);
    System.out.println(max);
  }

  public static int dfs(int y, int x) {
    visited[y][x] = true;
    int size = 1;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] == 1) {
        size += dfs(ny, nx);
      }
    }

    return size;
  }
}
