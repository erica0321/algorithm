import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static List<ArrayList<int[]>> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    list = new ArrayList<>();

    for(int i = 0; i <= N; i++){
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < N - 1; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.get(start).add(new int[]{end, weight});
      list.get(end).add(new int[]{start, weight});
    }

    if(N == 1){
      System.out.println(0);
      return;
    }

    int[] first = bfs(1);
    int farNode = first[0];

    int[] second = bfs(farNode);
    int diameter = second[1];

    System.out.println(diameter);
  }

  public static int[] bfs(int start){
    boolean[] visited = new boolean[N+1];
    int[] dist = new int[N+1];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.offer(start);

    while(!queue.isEmpty()){
      int cur = queue.poll();

      for(int[] edge : list.get(cur)){
        int next = edge[0];
        int weight = edge[1];
        if(!visited[next]){
          visited[next] = true;
          dist[next] = dist[cur] + weight;
          queue.offer(next);
        }
      }
    }

    int maxDist = 0;
    int maxNode = start;

    for(int i = 1; i <= N; i++){
      if(dist[i] > maxDist){
        maxDist = dist[i];
        maxNode = i;
      }
    }
    return new int[]{maxNode, maxDist};
  }
}
