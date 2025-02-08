import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      int dist = end - start;
      int maxCount = (int)Math.sqrt(dist);
      if(maxCount == Math.sqrt(dist)) {
        System.out.println(2 * maxCount - 1);
      } else if (dist <= maxCount * (maxCount + 1)) {
        System.out.println(2 * maxCount);
      } else {
        System.out.println(2 * maxCount + 1);
      }
    }
  }
}
