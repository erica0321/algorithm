import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int[] arr = new int[num];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i<num; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[num];
    dp[0] = arr[0];
    int max = dp[0];

    for(int i =1; i<num; i++) {
      dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
