import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] junseo = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      junseo[i][0] = Integer.parseInt(st.nextToken());
      junseo[i][1] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= K; j++) {
        if (junseo[i - 1][0] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - junseo[i - 1][0]] + junseo[i - 1][1]);
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}
