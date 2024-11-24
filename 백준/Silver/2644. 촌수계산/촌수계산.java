import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static int N, M, start, end;
  public static int answer = -1;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];

    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    for(int i =0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    M = Integer.parseInt(br.readLine());
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    dfs(start, 0);
    System.out.println(answer);
  }

  public static void dfs(int s, int length) {
    if(s == end) {
      answer = length;
      return;
    }
    visited[s] = true;

    for(int node: list.get(s)) {
      if(!visited[node]) {
        dfs(node, length + 1);
      }
    }
  }
}
