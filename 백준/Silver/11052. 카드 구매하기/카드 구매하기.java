import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] map = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =1; i<=n; i++) {
      map[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n+1];
    dp[0] = 0;
    for(int i =1; i<=n; i++) {
      for(int j = 1; j<=i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j] + map[j]);
      }
    }

    System.out.println(dp[n]);
  }
}
