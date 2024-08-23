import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int N = 0;
  public static int M = 0;
  public static int[] times;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    times = new int[N];
    String[] str = br.readLine().split(" ");
    for(int i = 0; i<N; i++) {
      times[i] = Integer.parseInt(str[i]);
    }

    Arrays.sort(times);
    long min = 1;
    long max = (long) times[N - 1] * M;

    long answer = BSearch(min, max);
    System.out.println(answer);
  }

  public static long BSearch(long min, long max) {
    long answer = max;
    while(min <= max) {
      long mid = (max + min) / 2;
      long possible = 0;

      for(long time: times) {
        possible += mid / time;
      }

      if(possible >= M) {
        answer = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return answer;
  }
}
