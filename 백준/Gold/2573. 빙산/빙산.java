import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int[][] map, sea;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    sea = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int year = 0;
    while(true) {
      int seperate = 0;
      visited = new boolean[N][M];

      boolean hasIce = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] > 0) {
            hasIce = true;
          }
        }
      }

      if (!hasIce) {
        System.out.println(0);
        return;
      }

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          sea[i][j] = count(i, j);
        }
      }

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          if(visited[i][j] || map[i][j] == 0) continue;
          seperate++;
          dfs(i, j, visited);
        }
      }

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          map[i][j] = Math.max(0, map[i][j] - sea[i][j]);
        }
      }

      if(seperate >= 2) break;
      year++;
    }
    System.out.println(year);
  }

  public static int count(int i, int j) {
    int result = 0;
    for(int k = 0; k < 4; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];
      if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
        result++;
      }
    }
    return result;
  }

  public static void dfs(int i, int j, boolean[][] visited) {
    visited[i][j] = true;
    for(int k = 0; k < 4; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];

      if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
      dfs(nx, ny, visited);
    }
  }
}
