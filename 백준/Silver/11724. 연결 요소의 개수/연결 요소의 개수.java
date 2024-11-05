import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N+1];

    for(int i =0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      list.get(start).add(end);
      list.get(end).add(start);
    }

    for(int i = 1; i<=N; i++) {
      if(!visited[i]) {
        answer ++;
        bfs(i);
      }
    }
    System.out.println(answer);
  }

  public static void bfs(int node) {
    Queue<Integer> q = new LinkedList<>();
    q.add(node);
    visited[node] = true;

    while(!q.isEmpty()) {
      int current = q.poll();
      ArrayList<Integer> temp = list.get(current);
      for(int idx : temp) {
        if(!visited[idx]) {
          q.add(idx);
          visited[idx] = true;
        }
      }
    }
  }
}
