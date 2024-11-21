import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int answer = Integer.MIN_VALUE;
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N - 2; i++) {
      bruteForce(i + 1, 1, arr[i]);
    }

    System.out.println(answer);
  }

  public static void bruteForce(int start, int length, int sum) {
    if (length == 3) {
      if (sum <= M) {
        answer = Math.max(answer, sum);
      }
      return;
    }

    for (int i = start; i < N; i++) {
      bruteForce(i + 1, length + 1, sum + arr[i]);
    }
  }
}
