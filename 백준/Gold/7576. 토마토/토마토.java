import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int M;
  public static int[][] map;
  public static Queue<int[]> tomatoes;

  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    tomatoes = new LinkedList<>();
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i = 0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) {
          tomatoes.add(new int[]{i, j});
        }
      }
    }

    bfs();

  }

  public static void bfs() {
    while(!tomatoes.isEmpty()) {
      int[] temp = tomatoes.poll();
      int x = temp[0], y = temp[1];

      for(int i =0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(map[nx][ny] == 0) {
          map[nx][ny] = map[x][y] + 1;
          tomatoes.add(new int[]{nx, ny});
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(map[i][j] == 0) {
          System.out.println(-1);
          return;
        }
      }
    }

    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        max = Math.max(max, map[i][j]);
      }
    }

    System.out.println(max - 1);
  }
}
