import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, M;
  public static ArrayList<ArrayList<Integer>> list;
  public static int max = Integer.MIN_VALUE;
  public static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(b).add(a);
    }

    int[] result = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      result[i] = bfs(i);
      max = Math.max(max, result[i]);
    }

    for (int i = 1; i <= N; i++) {
      if (result[i] == max) {
        System.out.print(i + " ");
      }
    }
  }

  public static int bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    int count = 0;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      count++;
      for (int next : list.get(current)) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }

    return count; 
  }
}
