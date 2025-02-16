import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, M;
  public static List<ArrayList<Integer>> list;
  public static List<Integer> target;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    for(int i =0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 1; j<=N; j++) {
        int temp = Integer.parseInt(st.nextToken());
        if(temp == 1) list.get(i).add(j);
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    target = new ArrayList<>();
    for(int i = 1; i<=M; i++) {
      target.add(Integer.parseInt(st.nextToken()));
    }

    boolean start = bfs(target.get(0));

    if (start) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public static boolean bfs(int start) {
    boolean[] visited = new boolean[N + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int node : list.get(cur)) {
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }

    for (int city : target) {
      if (!visited[city]) {
        return false;
      }
    }
    return true;
  }
}
