import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] groups = br.readLine().split("-");
    int result = 0;

    for (int i = 0; i < groups.length; i++) {
      String[] adds = groups[i].split("\\+");
      int sum = 0;
      for (String str : adds) {
        sum += Integer.parseInt(str);
      }
      if (i == 0) {
        result = sum;
      } else {
        result -= sum;
      }
    }
    System.out.println(result);
  }
}