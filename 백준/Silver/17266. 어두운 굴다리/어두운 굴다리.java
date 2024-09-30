import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] lights = new int[M];

    for (int i = 0; i < M; i++) {
      lights[i] = Integer.parseInt(st.nextToken());
    }

    int min = 0;
    int max = N;
    int result = 0;

    while (min <= max) {
      int mid = (min + max) / 2;
      int lastLit = 0;
      boolean isLighted = true;

      for (int light : lights) {
        if (light - mid > lastLit) {
          isLighted = false;
          break;
        }
        lastLit = light + mid;
      }

      if (lastLit < N) {
        isLighted = false;
      }

      if (isLighted) {
        result = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.println(result);
  }
}
