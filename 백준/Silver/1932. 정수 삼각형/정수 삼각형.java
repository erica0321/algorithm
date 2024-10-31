import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int[][] dp = new int[num][num];
    int[][] arr = new int[num][num];

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = arr[0][0];

    for (int i = 1; i < num; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + arr[i][j];
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int temp : dp[num - 1]) {
      max = Math.max(max, temp);
    }
    System.out.println(max);
  }
}
