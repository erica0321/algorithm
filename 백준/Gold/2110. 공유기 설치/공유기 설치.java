import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, C;
  static int[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new int[N];
    for(int i = 0; i < N; i++){
      map[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(map);

    int min = 1;
    int max = map[N-1] - map[0];
    int answer = 0;

    while(min <= max) {
      int mid = (min + max) / 2;
      int count = install(mid);
      if(count >= C) {
        answer = mid;
        min = mid + 1;
      }
      else {
        max = mid - 1;
      }
    }
    System.out.println(answer);
  }

  public static int install(int dist) {
    int count = 1;
    int start = map[0];

    for(int i = 1; i < N; i++) {
      if(map[i] - start >= dist) {
        count++;
        start = map[i];
      }
    }
    return count;
  }
}
