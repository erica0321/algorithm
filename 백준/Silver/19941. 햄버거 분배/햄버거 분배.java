import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer = 0;
    int tableLength = Integer.parseInt(st.nextToken());
    int eat = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    char[] arr = st.nextToken().toCharArray();
    boolean[] isEat = new boolean[tableLength];

    for(int i = 0; i < tableLength; i++) {
      if(arr[i] == 'P') {
        for(int j = -eat; j <= eat; j++) {
          if(i + j >= tableLength) break;
          if(i + j < 0) continue;

          if(arr[i+j] == 'H' && !isEat[i+j]) {
            isEat[i+j] = true;
            answer += 1;
            break;
          }
        }
      }
    }

    System.out.println(answer);

  }
}
