import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static boolean[] visited;
  public static int max = Integer.MIN_VALUE;
  public static int[] arr;
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    visited = new boolean[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i =0; i<N; i++) {
      int[] temp = new int[N];
      dfs(0, temp, 0);
    }
    System.out.println(max);
  }

  public static void dfs(int len,int[] temp, int sum) {
    if (len == N) {
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        temp[len] = arr[i];

        if (len > 0) {
          dfs(len + 1, temp, sum + Math.abs(temp[len] - temp[len - 1]));
        } else {
          dfs(len + 1, temp, sum);
        }

        visited[i] = false;
      }
    }
  }
}
