import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, M;
  public static int[] dist;
  public static ArrayList<ArrayList<int[]>> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new ArrayList<>(N + 1);
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end   = Integer.parseInt(st.nextToken());
      int cost  = Integer.parseInt(st.nextToken());

      arr.get(start).add(new int[]{end, cost});
      arr.get(end).add(new int[]{start, cost});
    }

    dijkstra();
    System.out.println(dist[N]);
  }

  public static void dijkstra() {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    dist[1] = 0;
    pq.add(new int[]{1, 0});

    while (!pq.isEmpty()) {
      int[] now = pq.poll();
      int currentNode = now[0];
      int currentDist = now[1];

      if (dist[currentNode] < currentDist) {
        continue;
      }
      for (int[] edge : arr.get(currentNode)) {
        int nextNode = edge[0];
        int nextCost = edge[1];
        int newDist  = currentDist + nextCost;

        if (dist[nextNode] > newDist) {
          dist[nextNode] = newDist;
          pq.add(new int[]{nextNode, newDist});
        }
      }
    }
  }
}
