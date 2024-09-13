import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int nodes;
  public static int edgeNum;
  public static int start;
  public static int[][] edges;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    nodes = Integer.parseInt(st.nextToken());
    edgeNum = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());
    edges = new int[nodes + 1][nodes + 1];
    visited = new boolean[nodes + 1];

    for (int i = 0; i < edgeNum; i++) {
      st = new StringTokenizer(br.readLine());
      int startEdge = Integer.parseInt(st.nextToken());
      int endEdge = Integer.parseInt(st.nextToken());

      edges[startEdge][endEdge] = 1;
      edges[endEdge][startEdge] = 1;
    }

    DFS(start);
    System.out.println();

    visited = new boolean[nodes + 1];
    BFS(start);
  }

  public static void DFS(int start) {
    visited[start] = true;
    System.out.print(start + " ");
    for (int i = 1; i <= nodes; i++) {
      if (edges[start][i] == 1 && !visited[i]) {
        DFS(i);
      }
    }
  }

  public static void BFS(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;
    System.out.print(start + " ");

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = 1; i <= nodes; i++) {
        if (edges[cur][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          System.out.print(i + " ");
        }
      }
    }
  }
}