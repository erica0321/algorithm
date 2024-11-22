import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      String[] list = new String[N];
      for(int j =0; j<N; j++) {
        list[j] = br.readLine();
      }
      Arrays.sort(list);
      boolean isNotValid = false;
      for(int j =0; j<N-1; j++) {
        if(list[j+1].startsWith(list[j])) {
          isNotValid = true;
        }
      }
      if(isNotValid) System.out.println("NO");
      else System.out.println("YES");
    }
  }
}
