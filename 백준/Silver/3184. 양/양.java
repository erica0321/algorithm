import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int R, C;
  public static char[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    int remainingSheep = 0;
    int remainingWolf = 0;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (!visited[i][j] && map[i][j] != '#') {
          int[] result = exploreArea(i, j);
          int sheepInArea = result[0];
          int wolfInArea = result[1];

          if (sheepInArea > wolfInArea) {
            remainingSheep += sheepInArea;
          } else {
            remainingWolf += wolfInArea;
          }
        }
      }
    }

    System.out.println(remainingSheep + " " + remainingWolf);
  }

  public static int[] exploreArea(int y, int x) {
    visited[y][x] = true;

    int sheep = 0;
    int wolf = 0;

    if (map[y][x] == 'o') sheep++;
    if (map[y][x] == 'v') wolf++;

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx] && map[ny][nx] != '#') {
        int[] result = exploreArea(ny, nx);
        sheep += result[0];
        wolf += result[1];
      }
    }

    return new int[]{sheep, wolf};
  }
}
