import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int V, E, start;
  static ArrayList<ArrayList<Node>> graph;

  static class Node {
    int idx, cost;

    Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    start = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();

    for(int i =0 ; i<=V; i++) {
      graph.add(new ArrayList<Node>());
    }

    for(int i =0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph.get(start).add(new Node(end, cost));
    }

    int[] dist = new int[V+1];
    for(int i =0; i<=V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    pq.offer(new Node(start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();

      if(dist[curNode.idx] < curNode.cost) {
        continue;
      }
      for(int i =0; i<graph.get(curNode.idx).size(); i++) {
        Node nextNode = graph.get(curNode.idx).get(i);
        if(dist[nextNode.idx] > curNode.cost + nextNode.cost) {
          dist[nextNode.idx] = curNode.cost + nextNode.cost;
          pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
        }
      }
    }

    for(int i =1; i<=V; i++) {
      if(dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else System.out.println(dist[i]);
    }
  }
}