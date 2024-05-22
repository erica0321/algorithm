import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;

class Graph {
  private int V;
  private ArrayList<LinkedList<Integer>> adj;

  Graph(int v) {
    V = v;
    adj = new ArrayList<>(v);

    for (int i = 0; i < v; i++) {
      adj.add(new LinkedList<>());
    }
  }

  void addEdge(int v, int w) {
    adj.get(v-1).add(w-1);
    adj.get(w-1).add(v-1);
    Collections.sort(adj.get(v-1));
    Collections.sort(adj.get(w-1));
  }

  void DFS(int v) {
    boolean visited[] = new boolean[V];
    DFSUtil(v, visited);
  }

  void DFSUtil(int v, boolean visited[]) {
    visited[v] = true;
    System.out.print((v + 1) + " ");
    Iterator<Integer> it = adj.get(v).iterator();
    while (it.hasNext()) {
      int n = it.next();
      if (!visited[n]) {
        DFSUtil(n, visited);
      }
    }
  }

  void BFS(int s) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[s] = true;
    queue.add(s);
    System.out.print((s + 1) + " ");

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      Iterator<Integer> it = adj.get(curr).iterator();

      while (it.hasNext()) {
        int n = it.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
          System.out.print((n + 1) + " ");
        }
      }
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String info = scanner.nextLine();
    int v = Integer.parseInt(info.split(" ")[0]);
    int e = Integer.parseInt(info.split(" ")[1]);
    int start = Integer.parseInt(info.split(" ")[2]);

    Graph graph = new Graph(v);

    for (int i = 0; i < e; i++) {
      String[] edge = scanner.nextLine().split(" ");
      int edge_start = Integer.parseInt(edge[0]);
      int edge_end = Integer.parseInt(edge[1]);

      graph.addEdge(edge_start, edge_end);
    }

    graph.DFS(start - 1);
    System.out.println();
    graph.BFS(start - 1);
  }
}
