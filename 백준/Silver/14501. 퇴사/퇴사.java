import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int answer = Integer.MIN_VALUE;
  public static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][2];
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N+1];

    for(int i =0; i<N; i++) {
      if(i + arr[i][0] <= N) {
        dp[i + arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i] + arr[i][1]);
      }
      dp[i+1] = Math.max(dp[i+1], dp[i]);
    }

    System.out.println(dp[N]);
  }

}
