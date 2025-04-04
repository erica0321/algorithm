import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] card = new int[10001];
    for(int i = 1; i<=N; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[10001];
    for(int i = 1; i<=N; i++) {
      dp[i] = card[i];
      for(int j = 1; j<=i; j++) {
        dp[i] = Math.min(dp[i], dp[i-j]+card[j]);
      }
    }
    System.out.println(dp[N]);
  }
}
