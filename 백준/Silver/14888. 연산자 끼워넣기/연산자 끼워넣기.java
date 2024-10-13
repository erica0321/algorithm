import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static int[] arr;
  public static int min = Integer.MAX_VALUE;
  public static int max = Integer.MIN_VALUE;
  public static int[] operator = new int[4];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];

    for(int i =0; i< N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i =0; i< 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    dfs(1, arr[0]); 
    System.out.println(max);
    System.out.println(min);

  }

  public static void dfs(int depth, int result) {
    if(depth == N) {
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for(int i =0; i<4; i++) {
      if(operator[i] > 0) {
        operator[i] -= 1;

        switch(i) {
          case 0:
            dfs(depth + 1, result + arr[depth]); 
            break;
          case 1:
            dfs(depth + 1, result - arr[depth]); 
            break;
          case 2:
              dfs(depth + 1, result * arr[depth]);
              break;
          case 3:
            dfs(depth + 1, result / arr[depth]); 

        }
        operator[i] += 1;
      }
    }
  }
}