import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long start = Integer.parseInt(st.nextToken());
    long target = Integer.parseInt(st.nextToken());

    dfs(start, target, 0);

    System.out.println(min == Integer.MAX_VALUE ? -1 : min + 1);
  }

  public static void dfs(long start, long target, int count) {
    if (start == target) {
      min = Math.min(min, count);
      return;
    }

    if (start > target) {
      return;
    }

    dfs(start * 10 + 1, target, count + 1);
    dfs(start * 2, target, count + 1);
  }
}
