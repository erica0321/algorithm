import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int[][] cheese;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0,};
  public static int[] dy = {0, 0, -1,  1};
  public static int left = 0;
  public static int time = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    cheese = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int isCheese = Integer.parseInt(st.nextToken());
        if(isCheese == 1) left ++;
        cheese[i][j] = isCheese;
      }
    }

    int lastCheese = 0;
    while(left > 0) {
      time ++;
      lastCheese = left;
      visited = new boolean[N][M];
      bfs();
    }

    System.out.println(time);
    System.out.println(lastCheese);
  }

  // 공기에서 부터 시작
  public static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    visited = new boolean[N][M];
    visited[0][0] = true;

    List<int[]> meltList = new LinkedList<>();

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

        visited[nx][ny] = true;
        if (cheese[nx][ny] == 0) {
          q.offer(new int[]{nx, ny});
        } else {
          meltList.add(new int[]{nx, ny});
        }
      }
    }

    for (int[] meltCheese : meltList) {
      int x = meltCheese[0];
      int y = meltCheese[1];
      if (cheese[x][y] == 1) {
        cheese[x][y] = 0;
        left--;
      }
    }
  }
}