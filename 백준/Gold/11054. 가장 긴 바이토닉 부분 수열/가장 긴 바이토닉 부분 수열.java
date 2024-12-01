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

    int[] l_dp = new int[n+1];
    int[] r_dp = new int[n+1];

    for(int i = 1; i<=n; i++) {
      l_dp[i] = 1;
      for(int j = 1; j< i; j++) {
        if(str[i] > str[j]) {
          l_dp[i] = Math.max(l_dp[i], l_dp[j]+1);
        }
      }
    }

    for(int i = n; i > 0; i--) {
      r_dp[i] = 1;
      for(int j = n; j > i; j--) {
        if(str[i] > str[j]) {
          r_dp[i] = Math.max(r_dp[i], r_dp[j]+1);
        }
      }
    }

    int max = 0;
    for(int i = 1; i<=n; i++) {
      max = Math.max(max, l_dp[i] + r_dp[i]);
    }

    System.out.println(max-1);
  }
}
