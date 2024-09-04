import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int[] dp = new int[num + 1];
    int[] weight = new int[num + 1];

    for (int i = 1; i <= num; i++) {
      weight[i] = Integer.parseInt(br.readLine());
    }

    if (num == 1) {
      System.out.println(weight[1]);
      return;
    }

    dp[1] = weight[1];
    dp[2] = weight[1] + weight[2];

    for (int i = 3; i <= num; i++) {
      dp[i] = Math.max(dp[i - 2] + weight[i], dp[i - 3] + weight[i - 1] + weight[i]);
    }

    System.out.println(dp[num]);
  }
}
