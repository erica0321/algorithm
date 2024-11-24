import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static int[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    tree = new int[N];
    st = new StringTokenizer(br.readLine());

    int maxTree = Integer.MIN_VALUE;
    for(int i =0; i<N; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      maxTree = Math.max(maxTree, tree[i]);
    }

    System.out.println(BSearch(0, maxTree));
  }

  public static int BSearch(int min, int max) {
    int result = 0;

    while(min <= max) {
      int mid = (min + max) / 2;
      if(sum(mid) >= M) {
        result = mid;
        min = mid + 1;
      } else {
        max = mid -1;
      }
    }

    return result;
  }

  public static long sum(int length) {
    long count = 0;
    for (int j : tree) {
      if (j > length) {
        count += j - length;
      }
    }
    return count;
  }
}
