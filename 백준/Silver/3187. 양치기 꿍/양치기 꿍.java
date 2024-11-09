import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int R, C;
  public static int sheep, wolf;
  public static int ss, ww;
  public static boolean[][] visited;
  public static char[][] map;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    visited = new boolean[R][C];

    for(int i =0; i<R; i++) {
      String str = br.readLine();
      for(int j =0; j<C; j++) {
        char ch = str.charAt(j);
        if(ch == 'v') wolf += 1;
        else if(ch == 'k') sheep += 1;
        map[i][j] = str.charAt(j);
      }
    }

    for(int i =0; i<R; i++) {
      for(int j = 0; j<C; j++) {
        if(!visited[i][j] && map[i][j] != '#') {
          ss = 0;
          ww = 0;
          dfs(i, j);
          if(ss > ww) wolf -= ww;
          else sheep -= ss;
        }
      }
    }

    System.out.println(sheep + " " + wolf);

  }

  public static void dfs(int y, int x) {
    visited[y][x] = true;

    if(map[y][x] == 'k') { ss += 1;}
    if(map[y][x] == 'v') { ww += 1;}

    for(int i =0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx < 0 || nx >= C || ny < 0 || ny >= R || visited[ny][nx] || map[ny][nx] == '#') continue;
      dfs(ny, nx);
    }
  }
}
