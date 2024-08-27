import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N = 0;
  public static int M = 0;
  public static boolean[] visited;
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];

    dfs(1, 0);
  }

  public static void dfs(int at, int depth) {
    if(depth == M) {
      for(int num: arr) {
        if(num == 0) continue;
        System.out.print(num + " ");
      }
      System.out.println();
      return;
    }

    for(int i = at; i <= N; i++) {
      arr[depth] = i;
      dfs(i + 1, depth + 1);
    }
  }
}
