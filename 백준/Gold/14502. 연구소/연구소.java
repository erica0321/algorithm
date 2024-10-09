import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static int M;
  public static int[][] map;
  public static int maxZero = 0;
  public static int[][] virusMap;

  public static void main(String[] args) throws IOException {
    // 1. 벽세우기 -> 백트래킹
    // 2, 바이러스 퍼뜨리기 -> bfs
    // 3, 0개수 세기
    // 4. 최댓값 출력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);
    System.out.println(maxZero);

  }

  //1. 벽세우기 -> dfs
  public static void dfs(int depth) {
    if(depth == 3) {
      // 2. 바이러스 전파 코드 실행
      bfs();
      return;
    }

    for(int i = 0; i<N; i++) {
      for(int j = 0; j<M; j++) {
        if(map[i][j] == 0) {
          map[i][j] = 1;
          dfs(depth + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  //2. 바이러스 퍼뜨리기
  public static void bfs() {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    Queue<int[]> queue = new LinkedList<>();
    virusMap = new int[N][M];

    for(int i = 0; i<N; i++) {
      for(int j = 0; j<M; j++) {
        virusMap[i][j] = map[i][j];
        if(virusMap[i][j] == 2) {
          queue.offer(new int[]{i, j});
        }
      }
    }

    while(!queue.isEmpty()) {
      int[] virus = queue.poll();
      int x = virus[0];
      int y = virus[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M && virusMap[nx][ny] == 0) {
          virusMap[nx][ny] = 2;
          queue.offer(new int[]{nx, ny});
        }
      }
    }

    // 3. 0 개수 세기
    int answer = 0;
    for(int i = 0; i<N; i++) {
      for(int j = 0; j<M; j++) {
        if(virusMap[i][j] == 0) answer ++;
      }
    }

    // 4. 0 최댓값 구하기
    maxZero = Math.max(maxZero, answer);
  }
}