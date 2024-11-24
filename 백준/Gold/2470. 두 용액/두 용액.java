import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int start = 0;
    int end = N-1;
    int gap = Integer.MAX_VALUE;
    int result = 0;
    int num1 = 0, num2 = 0;

    while(start < end) {
      result = arr[start] + arr[end];
      int tempGap = Math.abs(result);
      if(tempGap < gap) {
        gap = tempGap;
        num1 = arr[start];
        num2 = arr[end];
      }
      if(result > 0) end -=1;
      else start++;
    }

    System.out.println(num1 + " " + num2);
  }
}
