import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static int k;
  public static ArrayList<String> answer = new ArrayList<>();
  public static char[] ch;
  public static boolean[] used;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    ch = new char[k];

    for(int i =0; i<k; i++) {
      ch[i] = st.nextToken().charAt(0);
    }

    for(int i =0; i<10; i++) {
      used = new boolean[10];
      used[i] = true;
      String str = String.valueOf(i);
      bf(i, 0, str);
    }
    System.out.println(answer.get(answer.size() -1));
    System.out.println(answer.get(0));
  }

  public static void bf(int start, int length, String str) {
    if(str.length() == k+1) {
      answer.add(str);
      return;
    }

    for(int i =0; i<10; i++) {
      if(!used[i]) {
        if(ch[length] == '<') {
          if(start < i) {
            used[i] = true;
            bf(i, length+1, str + i);
            used[i] = false;
          }
        } else {
          if(start> i) {
            used[i] = true;
            bf(i, length + 1, str + i);
            used[i] = false;
          }
        }
      }
    }
  }
}
