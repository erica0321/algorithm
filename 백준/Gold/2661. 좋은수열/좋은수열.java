import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dfs("");
  }
  public static void dfs(String str) {
    if(str.length() == N) {
      System.out.println(str);
      System.exit(0);
    }

    for (int i = 1; i <= 3; i++) {
      String newStr = str + i;
      if (isValid(newStr)) {
        dfs(newStr);
      }
    }
  }

  public static boolean isValid(String str) {
    int len = str.length();
    for (int i = 1; i <= len / 2; i++) {
      if (str.substring(len - i).equals(str.substring(len - 2 * i, len - i))) {
        return false;
      }
    }
    return true;
  }
}