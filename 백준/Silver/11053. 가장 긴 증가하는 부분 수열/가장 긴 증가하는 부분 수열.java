import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int[] arr = new int[num];
    int[] dp = new int[num];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < num; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }

    int answer = 1;
    for(int i = 1; i < num; i++) {
      for(int j = 0; j < i; j++) {
        if(arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]); 
    }

    System.out.println(answer);
  }
}
