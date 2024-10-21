import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static char[] vocab;
  public static int L, C;
  public static char[] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    vocab = new char[C];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i<C; i++) {
      vocab[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(vocab);

    result = new char[L];

    bt(0, 0);
  }

  public static void bt(int depth, int len) {
    if(len == L) {
      int mCount = 0;
      int jCount = 0;

      for(char ch : result) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') mCount ++;
        else jCount++;
      }

      if(mCount >= 1 && jCount >= 2) {
        System.out.println(new String(result));
      }
      return;
    }

    for(int i = depth; i<C; i++) {
      result[len] = vocab[i];
      bt(i+1, len+ 1);
    }
  }
}
