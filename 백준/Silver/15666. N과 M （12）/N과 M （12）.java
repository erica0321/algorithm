import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int[] numbers;
  public static int[] answers;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[N];
    answers = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    dfs(0, 0);

    System.out.print(sb);
  }

  public static void dfs(int start, int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(answers[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    int before = -1;
    for (int i = start; i < N; i++) {
      if (before != numbers[i]) {
        answers[depth] = numbers[i];
        before = numbers[i];
        dfs(i, depth + 1);
      }
    }
  }
}
