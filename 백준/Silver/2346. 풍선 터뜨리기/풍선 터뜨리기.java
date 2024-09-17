import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    ArrayDeque<int[]> list = new ArrayDeque<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i<N; i++) {
      int[] arr = {i+1, Integer.parseInt(st.nextToken())};
      list.add(arr);
    }

    while(list.size()>1){
      int[] arr= list.pollFirst();
      sb.append(arr[0]).append(" ");
      int n = arr[1];
      if(n>0) {
        for(int j=1; j<n;j++) {
          list.offerLast(list.pollFirst());
        }
      }
      else if(n<0){
        for(int j=n;j!=0;j++) {
          list.offerFirst(list.pollLast());
        }
      }
    }
    sb.append(list.pollFirst()[0]);
    System.out.println(sb);
  }
}