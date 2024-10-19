import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] dp = new int[30][30];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    makeDp();

    for(int i =0; i<tc; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      System.out.println(dp[M][N]);
    }
  }

  public static void makeDp() {
    for (int i = 0; i < 30; i++) {
      dp[i][i] = 1;
      dp[i][0] = 1;
    }

    for(int i =2; i<30; i++) {
      for(int j = 1; j<= i; j++) {
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
      }
    }
  }
}
