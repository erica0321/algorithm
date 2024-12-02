import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String target = br.readLine();

    while (target.length() > str.length()) {
      if (target.charAt(target.length() - 1) == 'A') {
        target = target.substring(0, target.length() - 1);
      } else if (target.charAt(target.length() - 1) == 'B') {
        target = new StringBuilder(target.substring(0, target.length() - 1)).reverse().toString();
      }
    }

    System.out.println(str.equals(target) ? 1 : 0);
  }
}
