import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[][] arr = new int[3][2];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int a = arr[0][0] * arr[1][1] + arr[1][0] * arr[2][1] + arr[2][0] * arr[0][1];
    int b = arr[0][1] * arr[1][0] + arr[1][1] * arr[2][0] + arr[2][1] * arr[0][0];

    if(a>b) System.out.println(1);
    if(a==b) System.out.println(0);
    if(a<b) System.out.println(-1);
  }
}
