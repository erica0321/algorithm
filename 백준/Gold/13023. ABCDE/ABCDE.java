import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> list;
  public static boolean found;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N];
    list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      list.get(start).add(end);
      list.get(end).add(start);
    }

    found = false;

    for (int i = 0; i < N; i++) {
      if (!found) dfs(i, 0);
    }

    if (found) System.out.println(1);
    else System.out.println(0);
  }

  public static void dfs(int node, int depth) {
    if (depth == 4) {
      found = true;
      return;
    }
    visited[node] = true;

    for (int neighbor : list.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, depth + 1);
        if (found) return;
      }
    }

    visited[node] = false;
  }
}
