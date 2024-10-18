import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static boolean[] visited;
  public static int[][] map;
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N];

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);
    System.out.println(min);
  }

  public static void dfs(int idx, int depth) {
    if (depth == N / 2) {
      int team1 = 0;
      int team2 = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (visited[i] && visited[j]) {
            team1 += map[i][j];
          } else if (!visited[i] && !visited[j]) {
            team2 += map[i][j];
          }
        }
      }

      int diff = Math.abs(team1 - team2);
      min = Math.min(min, diff);
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }
}
