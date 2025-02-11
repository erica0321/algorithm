import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, L, R;
  public static int[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static List<int[]> country; 

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];

    // 맵 입력
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int answer = 0;

    while(true) {
      boolean isMove = false;
      visited = new boolean[N][N];
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(!visited[i][j]) {
            int totalSum = bfs(i, j);
            if(country.size() > 1) {
              isMove = true;
              int average = totalSum / country.size();
              for (int[] pos : country) {
                map[pos[0]][pos[1]] = average;
              }
            }
          }
        }
      }
      if(isMove) answer++;
      else break;
    }

    System.out.println(answer);
  }

  public static int bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    country = new ArrayList<>();

    visited[x][y] = true;
    q.offer(new int[]{x, y});
    country.add(new int[]{x, y});

    int sum = map[x][y];

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];

      for(int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

        int diff = Math.abs(map[cx][cy] - map[nx][ny]);
        if(diff >= L && diff <= R) {
          visited[nx][ny] = true;
          q.offer(new int[]{nx, ny});
          country.add(new int[]{nx, ny});
          sum += map[nx][ny];
        }
      }
    }

    return sum;
  }
}
