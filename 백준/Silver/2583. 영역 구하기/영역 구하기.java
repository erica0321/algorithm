import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int[][] map;
  public static boolean[][] visited;
  public static int N, M;
  public static List<Integer> list = new ArrayList<>();
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    int num = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    visited = new boolean[M][N];

    for (int i = 0; i < num; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int j = y1; j < y2; j++) {
        for (int k = x1; k < x2; k++) {
          map[j][k] = 1;
        }
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] == 0) {
          int result = dfs(i, j);
          list.add(result);
        }
      }
    }

    int[] ans = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    Arrays.sort(ans);
    System.out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      System.out.print(ans[i] + " ");
    }
  }

  public static int dfs(int x, int y) {
    visited[x][y] = true;
    int result = 1;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
        result += dfs(nx, ny);
      }
    }
    return result;
  }
}
