import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, M, H;
  public static int[][][] map;
  public static Queue<int[]> tomatoes;

  public static int[] dx = {-1, 1, 0, 0, 0, 0};
  public static int[] dy = {0, 0, -1, 1, 0, 0};
  public static int[] dz = {0, 0, 0, 0, 1, -1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    tomatoes = new LinkedList<>();
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[N][M][H];

    for(int k = 0; k<H; k++) {
      for(int i = 0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j =0; j<M; j++) {
          map[i][j][k] = Integer.parseInt(st.nextToken());
          if(map[i][j][k] == 1) {
            tomatoes.add(new int[]{i, j, k});
          }
        }
      }
    }


    bfs();

  }

  public static void bfs() {
    while(!tomatoes.isEmpty()) {
      int[] temp = tomatoes.poll();
      int x = temp[0], y = temp[1], z = temp[2];

      for(int i =0; i<6; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        int nz = z + dz[i];

        if(nx < 0 || ny < 0 || nx >= N || ny >= M || nz < 0 || nz >= H) continue;
        if(map[nx][ny][nz] == 0) {
          map[nx][ny][nz] = map[x][y][z] + 1;
          tomatoes.add(new int[]{nx, ny, nz});
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for(int k =0; k<H; k++) {
      for(int i =0; i<N; i++) {
        for(int j =0; j<M; j++) {
          if(map[i][j][k] == 0) {
            System.out.println(-1);
            return;
          }
        }
      }
    }

    for(int k =0; k<H; k++) {
      for(int i =0; i<N; i++) {
        for(int j =0; j<M; j++) {
          max = Math.max(max, map[i][j][k]);
        }
      }
    }

    System.out.println(max - 1);
  }
}
