import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
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

    for(int i = 0; i < N; i++) {
      String str = br.readLine();
      for(int j = 0; j<M; j++) {
        if(str.charAt(j) == 'W') map[i][j] = 0;
        else map[i][j] = 1;
      }
    }

    int answer = -1;
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(map[i][j] == 1) {
          answer = Math.max(answer, bfs(i, j));
        }
      }
    }

    System.out.println(answer);
  }

  public static int bfs(int x, int y) {
    int result = 0;
    boolean[][] visited = new boolean[N][M];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y, 0});
    visited[x][y] = true;

    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      int count = cur[2];

      if(count > result) result = count;

      for(int i =0; i<4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];
        if( nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;
        queue.add(new int[]{nx, ny, cur[2] + 1});
        visited[nx][ny] = true;
      }
    }
    return result;
  }
}
