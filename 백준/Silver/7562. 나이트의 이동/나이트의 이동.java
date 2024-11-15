import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int startX, startY, endX, endY;
  public static int I;
  public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
  public static int[] dy = {-1, 1, -2, 2, 2, -2, 1, -1};
  public static boolean[][] visited;
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      I = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());
      min = Integer.MAX_VALUE;

      bfs(startX, startY);
      System.out.println(min);
    }
  }

  public static void bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    visited = new boolean[I][I];
    q.add(new int[]{x, y, 0});
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] start = q.poll();
      if (start[0] == endX && start[1] == endY) {
        min = start[2];
        return;
      }
      for (int i = 0; i < 8; i++) {
        int nx = start[0] + dx[i];
        int ny = start[1] + dy[i];
        if (nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]) {
          visited[nx][ny] = true;
          q.offer(new int[]{nx, ny, start[2] + 1});
        }
      }
    }
  }
}
