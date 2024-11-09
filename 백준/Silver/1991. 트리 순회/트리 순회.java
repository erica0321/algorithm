import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static char[] str;
  public static Map<Character, char[]> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    str = new char[N];
    map  = new HashMap<>();

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char root = st.nextToken().charAt(0);
      char left = st.nextToken().charAt(0);
      char right = st.nextToken().charAt(0);

      if(left == '.') left = '0';
      if(right == '.') right = '0';

      map.put(root, new char[]{left, right});
    }

    preOrder('A');
    System.out.println();
    inOrder('A');
    System.out.println();
    postOrder('A');
  }

  public static void preOrder(char start) {
    if(start == '0') return;
    System.out.print(start);
    preOrder(map.get(start)[0]);
    preOrder(map.get(start)[1]);
  }

  // 중위순회
  public static void inOrder(char start) {
    if(start == '0') return;
    inOrder(map.get(start)[0]);
    System.out.print(start);
    inOrder(map.get(start)[1]);
  }

  // 후위순회
  public static void postOrder(char start) {
    if(start == '0') return;
    postOrder(map.get(start)[0]);
    postOrder(map.get(start)[1]);
    System.out.print(start);
  }
}
