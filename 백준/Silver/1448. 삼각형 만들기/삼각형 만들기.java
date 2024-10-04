import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Integer arr[] = new Integer[N];

    for(int i = 0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int max_sum = 0;
    Arrays.sort(arr, Collections.reverseOrder());

    for(int i = 0; i<N-2; i++) {
      if(arr[i] < arr[i+1] + arr[i+2]) {
        max_sum = Math.max(max_sum, arr[i] + arr[i+1] + arr[i+2]);
      }
    }

    if(max_sum == 0) {
      System.out.println(-1);
      return;
    }
    System.out.println(max_sum);
  }

}
