import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] str = new int[n+1];
    for(int i =1; i<=n; i++) {
      str[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n+1];

    for(int i = 1; i<=n; i++) {
      dp[i] = str[i];
      for(int j = 1; j<i; j++) {
        if(str[j] < str[i]) {
          dp[i] = Math.max(dp[i], dp[j] + str[i]);
        }
      }
    }

    int max = 0;
    for(int i = 1; i<=n; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);

  }
}
