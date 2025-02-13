import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static List<int[]> list;
  public static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    parent = new int[N+1];
    for(int i = 1; i<=N; i++) {
      parent[i] = i;
    }

    for(int i =0; i<M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end =  Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.add(new int[]{start, end, weight});
    }

    list.sort(((o1, o2) -> o1[2] - o2[2]));

    int answer = 0;
    for(int i = 0; i<M; i++) {
     int[] node = list.get(i);
     if(find(node[0]) != find(node[1])) {
       answer += node[2];
       union(node[0], node[1]);
     }
    }
    System.out.println(answer);
  }

  public static void union(int i, int j) {
    i = find(i);
    j = find(j);

    if(i != j) {
      parent[j] = i;
    }
  }

  public static int find(int i) {
    if(i == parent[i]) return i;
    return parent[i] = find(parent[i]);
  }
}
