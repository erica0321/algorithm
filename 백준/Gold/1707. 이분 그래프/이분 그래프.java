import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static ArrayList<ArrayList<Integer>> list;
  public static int[] colored;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int nodes = Integer.parseInt(st.nextToken());
      int edges = Integer.parseInt(st.nextToken());

      list = new ArrayList<>();

      for (int i = 0; i <= nodes; i++) {
        list.add(new ArrayList<>());
      }

      for (int i = 0; i < edges; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        list.get(start).add(end);
        list.get(end).add(start);
      }

      colored = new int[nodes + 1];
      boolean result = true;

      for (int i = 1; i <= nodes; i++) {
        if (colored[i] == 0) {
          if (!bfs(i)) {
            result = false;
            break;
          }
        }
      }
      System.out.println(result ? "YES" : "NO");
    }
  }

  public static boolean bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    colored[start] = 1;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      int currentColor = colored[node];

      for (int neighbor : list.get(node)) {
        if (colored[neighbor] == 0) {
          colored[neighbor] = -currentColor;
          queue.offer(neighbor);
        } else if (colored[neighbor] == currentColor) {
          return false;
        }
      }
    }
    return true;
  }
}
