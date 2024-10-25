import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static int N;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    System.out.println((int)Math.pow(2, N) - 1);
    hanoi(N, 1, 2, 3);

    System.out.print(sb.toString());
  }

  public static void hanoi(int num, int st, int mid, int end) {
    if (num == 1) {
      sb.append(st).append(" ").append(end).append("\n");
      return;
    }
    hanoi(num - 1, st, end, mid);
    sb.append(st).append(" ").append(end).append("\n");
    hanoi(num - 1, mid, st, end);
  }
}
