import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static String[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    map = new String[N][N];
    visited = new boolean[N][N];

    // 1. RGB 입력 받기
    for(int i = 0; i<N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = String.valueOf(line.charAt(j));
      }
    }

    // 2. 적록 색맹 아닐때 dfs
    int normalCnt = 0;
    for(int i = 0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(!visited[i][j]) {
          dfs(i, j);
          normalCnt ++;
        }
      }
    }

    // 3. 적록 색맹일 때 dfs
    visited = new boolean[N][N];
    int unNormalCnt = 0;
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(Objects.equals(map[i][j], "G")) map[i][j] = "R";
      }
    }

    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(!visited[i][j]) {
          dfs(i, j);
          unNormalCnt ++;
        }
      }
    }

    System.out.println(normalCnt + " " + unNormalCnt);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;
    String area = map[x][y];
    for(int i = 0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && Objects.equals(map[nx][ny], area)) {
        dfs(nx, ny);
      }
    }
  }

}