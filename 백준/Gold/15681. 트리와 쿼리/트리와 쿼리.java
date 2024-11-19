import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, R, Q;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public static int[] size;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    for(int i = 0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    size = new int[N+1];
    visited = new boolean[N+1];

    for(int i =0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      list.get(start).add(end);
      list.get(end).add(start);
    }

    dfs(R);
    for(int i =0; i<Q; i++) {
      int node = Integer.parseInt(br.readLine());
      System.out.println(size[node]);
    }
  }

  public static int dfs(int start) {
    visited[start] = true;
    size[start] = 1;
    for(int child: list.get(start)) {
      if(!visited[child]) {
        size[start] += dfs(child);
      }
    }
    return size[start];
  }
}
