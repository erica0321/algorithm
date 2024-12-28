import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N + 1][3];

    int result_min = Integer.MAX_VALUE;
    int result_max = Integer.MIN_VALUE;

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] max = new int[N + 1][3];
    int[][] min = new int[N + 1][3];

    for (int j = 0; j < 3; j++) {
      max[1][j] = arr[1][j];
      min[1][j] = arr[1][j];
    }

    for (int i = 2; i <= N; i++) {
      max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
      min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];

      max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + arr[i][1];
      min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + arr[i][1];

      max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];
      min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
    }

    for (int i = 0; i < 3; i++) {
      result_max = Math.max(result_max, max[N][i]);
      result_min = Math.min(result_min, min[N][i]);
    }

    System.out.println(result_max + " " + result_min);
  }
}
