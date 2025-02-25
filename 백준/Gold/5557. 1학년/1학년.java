import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long[][] dp = new long[N-1][21];
    dp[0][arr[0]] = 1;

    for(int i = 1; i<N-1; i++) {
      for(int j = 0; j < 21; j++) {
        if(j - arr[i] >= 0) {
          dp[i][j] += dp[i - 1][j - arr[i]];
        }
        if(j + arr[i] <= 20) {
          dp[i][j] += dp[i - 1][j + arr[i]];
        }
      }
    }
    System.out.println(dp[N-2][arr[N-1]]);
  }
}
