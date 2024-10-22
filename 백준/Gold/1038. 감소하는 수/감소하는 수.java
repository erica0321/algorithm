import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static List<Long> list;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    list = new ArrayList<>();
    int num = Integer.parseInt(br.readLine());
    if (num <= 10) {
      System.out.println(num);
    } else if(num > 1022) System.out.println("-1");
    else {
      for(int i = 0; i < 10; i++) {
        find(1, i);
      }
      Collections.sort(list);

      System.out.println(list.get(num));
    }
  }

  public static void find(int idx, long num) {
    if(idx> 10) return;
    list.add(num);
    for(int i =0; i<num % 10; i++) {
      find(idx + 1, (num*10) + i);
    }
  }
}
