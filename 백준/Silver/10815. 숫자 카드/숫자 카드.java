import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int[] arr;
  public static int[] check;
  public static int[] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    check = new int[M];
    result = new int[M];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i<M; i++) {
      check[i] = Integer.parseInt(st.nextToken());
    }


    for(int i = 0; i<M; i++) {
      result[i] = BSearch(check[i]);
    }

    for(int i = 0; i<M; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int BSearch(int num) {
    int min = 0;
    int max = arr.length - 1;

    // 이진 탐색
    while (min <= max) {
      int mid = (min + max) / 2;
      if (arr[mid] == num) {
        return 1;
      } else if (arr[mid] < num) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return 0;
  }
}