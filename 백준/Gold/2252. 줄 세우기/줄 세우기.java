import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int[][] map;
  public static int N;
  public static int M;
  public static int[] edge;
  public static ArrayList<ArrayList<Integer>> graph;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    edge = new int[N+1];
    graph = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i <= N+1; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      graph.get(start).add(end);
      edge[end] ++;
    }
    bfs();
  }

  public static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    for(int i =1; i<edge.length; i++) {
      if(edge[i] == 0) queue.offer(i);
    }

    StringBuilder str = new StringBuilder();

    while(!queue.isEmpty()) {
      int student = queue.poll();
      str.append(student).append(" ");

      List<Integer> list = graph.get(student);

      for(int i = 0; i < list.size(); i++) {
        int num = list.get(i);
        edge[num]--;
        if(edge[num] == 0) {
          queue.offer(num);
        }
      }
    }

    System.out.println(str.toString());

  }
}