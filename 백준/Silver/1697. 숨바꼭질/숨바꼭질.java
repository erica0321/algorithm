import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, K;
  public static int[] time = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    if (N == K) {
      System.out.println(0);
      return;
    }
    bfs(N, K);
  }

  public static void bfs(int start, int end) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    time[start] = 0;

    while (!q.isEmpty()) {
      int temp = q.poll();

      for (int i = 0; i < 3; i++) {
        int cx = 0;
        switch (i) {
          case 0:
            cx = temp + 1;
            break;
          case 1:
            cx = temp - 1;
            break;
          case 2:
            cx = temp * 2;
            break;
        }
        if (cx == end) {
          System.out.println(time[temp] + 1);
          return;
        }

        if (cx >= 0 && cx < 100001 && time[cx] == 0) {
          q.add(cx);
          time[cx] = time[temp] + 1;
        }
      }
    }
  }
}
