import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static int E, V;
  public static int answer;
  public static ArrayList<ArrayList<int[]>> list;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    E = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    visited = new boolean[E + 1];

    for (int i = 0; i <= E; i++) {
      list.add(new ArrayList<>());
    }

    answer = 0;

    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.get(start).add(new int[]{end, weight});
      list.get(end).add(new int[]{start, weight});
    }

    prim(1);

    System.out.println(answer);
  }

  public static void prim(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[]{start, 0});

    while (!pq.isEmpty()) {
      int[] node = pq.poll();
      int current = node[0];
      int weight = node[1];

      if (visited[current]) continue;
      visited[current] = true;
      answer += weight;

      for (int[] next : list.get(current)) {
        int nx = next[0];
        int nx_w = next[1];

        if (!visited[nx]) {
          pq.add(new int[]{nx, nx_w});
        }
      }
    }
  }
}
