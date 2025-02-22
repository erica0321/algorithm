import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] str = new String[N];
    for (int i = 0; i < N; i++) {
      str[i] = br.readLine();
    }
    int len = str[0].length();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len; i++) {
      boolean same = true;
      char c = str[0].charAt(i);
      for (int j = 1; j < N; j++) {
        if (c != str[j].charAt(i)) same = false;
      }
      if (same) sb.append(c);
      else sb.append("?");
    }
    System.out.print(sb);
  }
}
