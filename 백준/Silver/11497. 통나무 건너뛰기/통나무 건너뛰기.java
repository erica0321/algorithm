import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int T;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++){
      int N = Integer.parseInt(br.readLine());
      arr  = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j =0; j<N; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr);

      int height = 0;
      for(int k =0; k<N-2; k++) {
        height = Math.max(height, Math.abs(arr[k] - arr[k+2]));
      }
      System.out.println(height);
    }
  }

}