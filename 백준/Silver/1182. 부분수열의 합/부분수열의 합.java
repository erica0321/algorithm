import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, S, answer;
  public static int[] num;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    answer = 0;

    st = new StringTokenizer(br.readLine());
    num = new int[N];
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);

    if (S == 0) answer -= 1; 
    System.out.println(answer);
  }

  public static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum == S) answer++;
      return;
    }

    dfs(depth + 1, sum + num[depth]);
    dfs(depth + 1, sum); 
  }
}
