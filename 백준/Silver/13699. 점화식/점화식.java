import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static long[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new long[N + 1];

    for(int i =0; i<=N; i++) {
      arr[i] = -1;
    }
    System.out.println(dp(N));
  }

  public static long dp(int n) {
    if(n <= 1) return 1;
    long sum = 0;

    if (arr[n] != -1) {
      return arr[n];
    }

    for(int i = 0 ; i < n; i++) {
      sum += dp(i) * dp(n-i-1);
    }
    
    arr[n] = sum;
    return arr[n];
  }
}
