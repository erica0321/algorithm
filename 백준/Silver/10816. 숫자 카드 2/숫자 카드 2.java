import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map <Integer, Integer> map = new TreeMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] find = new int[M];
    for(int i = 0; i < M; i++) {
      find[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for(int i =0 ; i < M; i++) {
      int a = Arrays.binarySearch(arr, find[i]);
      if(a >= 0) sb.append(map.get(find[i])).append(" ");
      else {sb.append("0 ");}
    }
    System.out.println(sb);
  }
}
