import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    Long[] arr = new Long[N];
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    int min = 0;
    int max = N-1;

    Long result = Long.MAX_VALUE;

    int num1 = 0;
    int num2 = 0;
    while(min < max) {
      long temp = arr[min] + arr[max];

      if(Math.abs(temp) < result) {
        result = Math.abs(temp);
        num1 = min;
        num2 = max;
      }
      if(temp > 0) max --;
      if(temp < 0) min ++;
      if(temp == 0) {
        System.out.println(arr[num1]+ " " + arr[num2]);
        return;
      }
    }
    System.out.println(arr[num1]+ " " + arr[num2]);
  }
}
