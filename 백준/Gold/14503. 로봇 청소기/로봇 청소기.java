import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M, result;
  public static int[][] map;
  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    result = 0;
    clean(r, c, d);
    System.out.println(result);
  }

  public static void clean(int y, int x, int dir) {
    if (map[y][x] == 0) {
      map[y][x] = 2;
      result++;
    }

    for (int i = 0; i < 4; i++) {
      dir = (dir + 3) % 4;
      int ny = y + dy[dir];
      int nx = x + dx[dir];

      if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
        clean(ny, nx, dir);
        return;
      }
    }

    int backDir = (dir + 2) % 4;
    int by = y + dy[backDir];
    int bx = x + dx[backDir];

    if (by >= 0 && by < N && bx >= 0 && bx < M && map[by][bx] != 1) {
      clean(by, bx, dir);
    }
  }
}
