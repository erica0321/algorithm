import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static long X = 0;
  public static long Y = 0;
  public static long Z = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    Z = Y * 100 / X ;

    long min = 0;
    long max = 1000000000;

    if (Z >= 99) {
      System.out.println(-1);
      return;
    }

    System.out.println(BSearch(min, max));
  }

  public static long BSearch(long min, long max) {
    while(min <= max) {
      long mid = (max + min) / 2;
      long winPer = (Y + mid) * 100 / (X + mid);

      if(winPer > Z) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return min;
  }
}
