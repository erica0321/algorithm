import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    for(int i = 0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      String result = bfs(start, end);
      System.out.println(result);
    }
  }

  public static String bfs(int start, int end) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[10000];
    String[] answer = new String[10000];
    queue.add(start);
    answer[start] = "";
    visited[start] = true;

    while(!queue.isEmpty()) {
      int cur = queue.poll();
      String path = answer[cur];

      if(cur == end) return path;

      int calcD = (cur * 2) % 10000;
      int calcS = cur == 0 ? 9999 : cur - 1;
      int calcL = cur / 1000 + (cur % 1000) * 10;
      int calcR = (cur % 10) * 1000 + cur / 10;

      if (!visited[calcD]) {
        visited[calcD] = true;
        queue.add(calcD);
        answer[calcD] = path + "D";
      }
      if (!visited[calcS]) {
        visited[calcS] = true;
        queue.add(calcS);
        answer[calcS] = path + "S";
      }
      if (!visited[calcL]) {
        visited[calcL] = true;
        queue.add(calcL);
        answer[calcL] = path + "L";
      }
      if (!visited[calcR]) {
        visited[calcR] = true;
        queue.add(calcR);
        answer[calcR] = path + "R";
      }
    }
    return "";
  }
}
