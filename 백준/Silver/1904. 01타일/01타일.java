import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N = 0;
  public static long[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    dp = new long[N+1];

    if(N == 0) {
      System.out.println(1);
      return;
    } else if(N == 1) {
      System.out.println(1);
      return;
    } else if (N==2) {
      System.out.println(2);
      return;
    }

    for(int i = 0; i <= N; i++) {
      dp[i] = -1;
    }

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    System.out.println(findDp(N));
  }

  public static long findDp(int num) {
    if(dp[num] == -1) {
      dp[num] = (findDp(num - 1) + findDp(num-2)) % 15746;
    }
    return dp[num];
  }
}
