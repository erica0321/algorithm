import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static char[][] map;
  public static boolean[][] visited;
  public static long wScore = 0L, bScore = 0L;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          long count = dfs(i, j, map[i][j]);
          if (map[i][j] == 'W') {
            wScore += count * count;
          } else {
            bScore += count * count;
          }
        }
      }
    }

    System.out.println(wScore + " " + bScore);
  }

  public static long dfs(int x, int y, char team) {
    visited[x][y] = true;
    long count = 1;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == team) {
        count += dfs(nx, ny, team);
      }
    }

    return count;
  }
}
