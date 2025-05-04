import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static int[][] map;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int step = 1;
    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) return;

      map = new int[N][N];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = bfs();
      System.out.println("Problem " + step + ": " + answer);
      step++;
    }
  }

  public static int bfs() {
    int[][] dp = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    dp[0][0] = map[0][0];
    queue.add(new int[]{0, 0, dp[0][0]});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0], y = cur[1], cost = cur[2];

      if (cost > dp[x][y]) continue;
      if (x == N - 1 && y == N - 1) {
        return cost;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        int nc = cost + map[nx][ny];
        if (nc < dp[nx][ny]) {
          dp[nx][ny] = nc;
          queue.add(new int[]{nx, ny, nc});
        }
      }
    }
    return dp[N-1][N-1];
  }
}
