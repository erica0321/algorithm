import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int MAX_VALUE = 10001;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] coins = new int[n+1];
    int[] dp = new int[k+1];

    for(int i = 1; i< k+1; i++) {
      dp[i] = MAX_VALUE;
    }

    dp[0] = 0;

    for(int i = 1; i <= n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    for(int i = 1; i<=n ; i++) {
      for(int j = coins[i]; j <= k ; j++) {
        dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
      }
    }
    
    if (dp[k] == MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[k]);
    }
  }
}
