import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int N;
  public static boolean[] visited;
  public static int[] parents;
  public static ArrayList<ArrayList<Integer>> list;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    parents = new int[N+1];
    visited = new boolean[N+1];
    list = new ArrayList<>();

    for(int i = 0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i<N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end =  Integer.parseInt(st.nextToken());

      list.get(start).add(end);
      list.get(end).add(start);
    }

    bfs(1);
    for(int i =2; i<=N; i++) {
      System.out.println(parents[i]);
    }
  }

  public static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    //루트 노드
    queue.add(start);
    //탐색 시작
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      visited[cur] = true;
      ArrayList<Integer> temp = list.get(cur);
      for(int i = 0; i<temp.size(); i++) {
        int target = temp.get(i);
        if(!visited[target]) {
          parents[target] = cur;
          queue.add(target);
        }
      }
    }
  }
}
