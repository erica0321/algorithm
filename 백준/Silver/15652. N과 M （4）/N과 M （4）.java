import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N = 0;
  public static int M = 0;
  public static int[] visited;
  public static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new int [M];

    dfs(0, 1);
    System.out.println(sb);
  }

  public static void dfs(int depth, int before ){
    if(depth == M) {
      for(int i = 0; i<M; i++) {
        sb.append(visited[i]).append(' ');
      }
      sb.append('\n');
      return;
    };
    for(int i = before; i<= N; i++) {
      visited[depth] = i;
      dfs(depth +1, i);
    }
  }
}
