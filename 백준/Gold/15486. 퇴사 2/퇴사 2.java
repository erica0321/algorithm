import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[][] work = new int[N+2][2];

    for(int i = 1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      work[i][0] = Integer.parseInt(st.nextToken());
      work[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] dp= new int[N+2];

    int result = 0;

    for(int i = 1; i<=N+1; i++) {
      result = Math.max(result, dp[i]);
      int next = i + work[i][0];
      if(next < N+2) {
        dp[next] = Math.max(dp[next], result + work[i][1]);
      }
    }

    System.out.println(dp[N+1]);
  }
}
