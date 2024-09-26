import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken()); 
      int n = Integer.parseInt(st.nextToken());

      List<int[]> testcase = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x_i = Integer.parseInt(st.nextToken());
        int w_i = Integer.parseInt(st.nextToken()); 
        testcase.add(new int[]{x_i, w_i});
      }

      int capacity = 0;
      int distance = 0;
      int previousValue = 0;

      for (int i = 0; i < testcase.size(); i++) {
        int[] curr = testcase.get(i);
        int distanceFromDump = curr[0];
        int trashAmount = curr[1];

        if (capacity + trashAmount < w) {
          distance += distanceFromDump - previousValue;
          capacity += trashAmount;
        } else if (capacity + trashAmount == w) {
          distance += (distanceFromDump - previousValue) + distanceFromDump * 2;
          capacity = 0;
          if (i == n - 1) {
            distance -= distanceFromDump * 2;
          }
        } else if (capacity + trashAmount > w) {
          capacity = trashAmount;
          distance += (distanceFromDump - previousValue) + distanceFromDump * 2;
        }
        previousValue = distanceFromDump;
      }

      distance += testcase.get(testcase.size() - 1)[0];
      System.out.println(distance);
    }
  }
}
