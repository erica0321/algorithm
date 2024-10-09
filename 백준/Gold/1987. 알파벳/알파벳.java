import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int R;
  public static int C;
  public static char[][] map;
  public static int max = 0; 
  public static boolean[] visitedAlphabets = new boolean[26]; 
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    visitedAlphabets[map[0][0] - 'A'] = true;

    dfs(0, 0, 1);

    System.out.println(max);
  }

  public static void dfs(int x, int y, int count) {
    max = Math.max(max, count);

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
        int charIndex = map[nx][ny] - 'A';
        if (!visitedAlphabets[charIndex]) { 
          visitedAlphabets[charIndex] = true; 
          dfs(nx, ny, count + 1);  
          visitedAlphabets[charIndex] = false; 
        }
      }
    }
  }
}
