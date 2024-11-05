import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static int N, count = 0;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    backtracking(0);
    System.out.println(count);
  }


  public static void backtracking(int depth) {
    if(depth == N) {
      count ++;
      return;
    }

    for(int i = 0; i < N; i++) {
      arr[depth] = i;
      if(can(depth)) backtracking(depth +1);
    }
  }

  public static boolean can(int depth) {
    for(int i =0; i< depth; i++) {
      if(arr[i] == arr[depth]) return false;
      else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
    }
    return true;
  }
}
