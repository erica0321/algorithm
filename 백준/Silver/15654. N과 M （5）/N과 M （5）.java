import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static int N = 0;
  public static int M = 0;
  public static int[] numbers;
  public static int[] arr;
  public static boolean[] visited;

  public static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    numbers = new int[N];
    arr = new int[M];
    visited = new boolean[N];

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    for(int i = 0; i< N; i++) {
      numbers[i] = Integer.parseInt(st1.nextToken());
    }

    Arrays.sort(numbers);

    dfs(0);
    System.out.println(sb);
  }

  public static void dfs(int depth ){
    if(depth == M) {
      for(int i = 0; i<M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    for(int i = 0; i< N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        arr[depth] = numbers[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}
