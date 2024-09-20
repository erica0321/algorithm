import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int testCase = 0;
  public static int ANum = 0;
  public static int BNum = 0;
  public static int[] A;
  public static int[] B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    testCase = Integer.parseInt(br.readLine());

    for(int i =0; i<testCase; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      ANum = Integer.parseInt(st.nextToken());
      BNum = Integer.parseInt(st.nextToken());

      A = new int[ANum];
      B = new int[BNum];

      StringTokenizer st1 = new StringTokenizer(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for(int j = 0; j< ANum; j++) {
        A[j] = Integer.parseInt(st1.nextToken());
      }
      for(int j =0 ; j<BNum; j++) {
        B[j] = Integer.parseInt(st2.nextToken());
      }

      Arrays.sort(B);

      int count = 0;
      for(int j =0; j<ANum; j++) {
        count += BSearch(A[j], B);
      }

      System.out.println(count);
    }
  }

  public static int BSearch(int num, int[] arr) {
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
      int mid = (min + max) / 2;
      if (arr[mid] < num) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return min;
  }
}
