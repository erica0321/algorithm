import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int[] sang;
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    sang = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i< N; i++) {
      sang[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(sang);

    int M = Integer.parseInt(br.readLine());
    int[] arr = new int[M];

    st = new StringTokenizer(br.readLine());
    for(int i =0; i<M; i++) {
      arr[i] = BSearch(Integer.parseInt(st.nextToken()));
    }

    for(int num: arr) {
      System.out.print(num + " ");
    }
  }

  public static int BSearch(int num) {
    int min = 0;
    int max = N-1;

    while(min <= max) {
      int mid = (max+min)/2;
      if(num == sang[mid]) { return 1 ;}
      else if(num < sang[mid]) {
        max = mid -1;
      } else {
        min =mid + 1;
      }
    }
    return 0;
  }
}
