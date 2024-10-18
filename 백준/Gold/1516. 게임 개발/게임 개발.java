import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static int[] edge;
  public static int[] time;
  public static int[] total;
  public static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    edge = new int[N+1];
    time = new int[N+1];
    total = new int[N+1];

    for (int i = 0; i <= N+1; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for(int i = 1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i] = Integer.parseInt(st.nextToken());
      int temp = Integer.parseInt(st.nextToken());
      while(temp != -1) {
        graph.get(temp).add(i);
        edge[i] ++;
        temp = Integer.parseInt(st.nextToken());
      }
    }

    bfs();
  }

  public static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for(int i =1; i<=N; i++) {
      if(edge[i] == 0) queue.offer(i);
    }

    while(!queue.isEmpty()) {
      int building = queue.poll();
      List<Integer> list = graph.get(building);

      for (int i = 0; i < list.size(); i++) {
        int num = list.get(i);
        edge[num]--;
        total[num] = Math.max(total[num], total[building] + time[building]);

        if (edge[num] == 0) queue.offer(num);
      }
    }

    for(int i =1; i<=N; i++) {
      sb.append((total[i] + time[i]) + "\n");
    }

    System.out.println(sb.toString());
  }
}