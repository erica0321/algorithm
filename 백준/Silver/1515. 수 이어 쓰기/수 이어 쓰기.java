import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int point = 0;
    int base = 0;

    while(base++ <= 30000) {
      String s = String.valueOf(base);
      for(int i =0; i< s.length(); i++) {
        if(s.charAt(i) == str.charAt(point)) {
          point ++;
        }
        if(point == str.length()) {
          System.out.println(base);
          return;
        }
      }
    }
  }
}
