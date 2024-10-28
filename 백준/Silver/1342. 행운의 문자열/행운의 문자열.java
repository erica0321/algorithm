import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static int N, count = 0;
  public static String[] arr;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arr = br.readLine().split("");
    N = arr.length;
    visited = new boolean[N];

    Arrays.sort(arr);
    backtrack("");
    System.out.println(count);
  }

  public static void backtrack(String str) {
    if (str.length() == N) { 
      count++;
      return;
    }

    String lastUsed = ""; 
    for (int i = 0; i < N; i++) {
      if (!visited[i] && !arr[i].equals(lastUsed)) {
        if (str.isEmpty() || str.charAt(str.length() - 1) != arr[i].charAt(0)) { 
          visited[i] = true;
          lastUsed = arr[i];
          backtrack(str + arr[i]); 
          visited[i] = false;
        }
      }
    }
  }
}
