import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int M;
  public static int[][] map;
  public static boolean[][] visited;
  public static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];

    // 1. 미로 입력
    for(int i = 0; i<N; i++) {
      String line = br.readLine();
      for(int j = 0; j<M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    // 2. dfs 탐색
    bfs(0, 0);
    System.out.println(map[N-1][M-1]);
  }

  public static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0,0};


    while(!queue.isEmpty()) {
      int[] temp = queue.poll();
      int cx = temp[0];
      int cy = temp[1];

      for(int i = 0; i<4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
          queue.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
          map[nx][ny] = map[cx][cy] + 1;
          count++;
        }
      }
    }

  }
}