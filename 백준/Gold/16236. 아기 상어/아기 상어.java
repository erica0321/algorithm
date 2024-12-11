import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static boolean[][] visited;
  public static int[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    visited = new boolean[N][N];
    int[] shark = new int[2];
    map = new int[N][N];
    for(int y =0; y<N; y++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int x =0; x<N; x++) {
        map[y][x] = Integer.parseInt(st.nextToken());
        if(map[y][x] == 9) {
          shark = new int[]{x, y};
          map[y][x] = 0;
        }
      }
    }

    int result = bfs(shark[1], shark[0]);
    System.out.println(result);
  }

  public static int bfs(int startY, int startX) {
    int size = 2;
    int eat = 0;
    int move = 0;

    while (true) {
      PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
          o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) :
              (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
      );

      boolean[][] visited = new boolean[N][N];
      queue.add(new int[]{startY, startX, 0});
      visited[startY][startX] = true;

      boolean foundFish = false;
      int[] nextShark = null;

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int cy = cur[0];
        int cx = cur[1];
        int dist = cur[2];

        if (map[cy][cx] > 0 && map[cy][cx] < size) {
          foundFish = true;
          nextShark = new int[]{cy, cx, dist};
          break;
        }

        for (int i = 0; i < 4; i++) {
          int ny = cy + dy[i];
          int nx = cx + dx[i];
          if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] > size) continue;
          queue.add(new int[]{ny, nx, dist + 1});
          visited[ny][nx] = true;
        }
      }

      if (!foundFish) break;

      startY = nextShark[0];
      startX = nextShark[1];
      move += nextShark[2];
      map[startY][startX] = 0;
      eat++;

      if (eat == size) {
        size++;
        eat = 0;
      }
    }

    return move;
  }
}
