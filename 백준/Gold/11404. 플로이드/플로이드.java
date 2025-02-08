import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int M;
  public static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    map = new int[N+1][N+1];

    // 초기화
    for(int i =1; i<=N; i++) {
      for(int j = 1; j<=N; j++) {
        map[i][j] = Integer.MAX_VALUE;

        if(i == j) map[i][j] = 0;
      }
    }

    // map 생성
    for(int i = 1; i<=M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int count = Integer.parseInt(st.nextToken());

      map[start][end] = Math.min(map[start][end], count);
    }

    // 최단거리 구하기
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) {
            continue;
          }
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }

    // 출력
    for(int i = 1; i<=N; i++) {
      for(int j = 1; j<=N; j++) {
        if(map[i][j] == Integer.MAX_VALUE) map[i][j] = 0;
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
