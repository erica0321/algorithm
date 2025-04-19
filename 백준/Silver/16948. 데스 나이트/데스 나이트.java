import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static int r1, c1, r2, c2;
  public static int[] dx = {-2, -2, 2, 2, 0, 0};
  public static int[] dy = {-1, 1, -1, 1, -2, 2};
  public static int[][] move;
  public static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    move = new int[N][N];
    visited = new boolean[N][N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());

    bfs(r1, c1);

    int result = move[r2][c2];
    System.out.println(result == 0 && (r1 != r2 || c1 != c2) ? -1 : result);
  }

  public static void bfs(int startX, int startY) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{startX, startY});
    visited[startX][startY] = true;
    move[startX][startY] = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 6; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (!visited[nx][ny]) {
          visited[nx][ny] = true;
          move[nx][ny] = move[cur[0]][cur[1]] + 1;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }
}
