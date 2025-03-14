import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[][] dp = new long[N + 1][10];
    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        dp[i][j] = 0;
        for (int k = j; k < 10; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= 10007;
        }
      }
    }

    long answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += dp[N][i];
    }

    System.out.println(answer % 10007);
  }
}
