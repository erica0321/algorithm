import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N, K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[] sensors = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sensors);

    Queue<Integer> q = new PriorityQueue<>();
    for(int i = 0; i<N-1; i++)
      q.offer(sensors[i+1] - sensors[i]);

    int answer = 0;

    for(int i = 0; i<N-K; i++)
      answer += q.poll();

    System.out.println(answer);
  }
}
