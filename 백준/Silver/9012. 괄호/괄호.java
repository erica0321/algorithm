import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for(int i = 0; i<n; i++) {
      String str = br.readLine();
      Stack<Character> stack = new Stack<>();
      for(int j=0; j<str.length(); j++) {
        Character ch = str.charAt(j);
        if (ch == '(') {
          stack.push(ch);
        } else if (ch == ')') {
          if (stack.isEmpty()) {
            stack.push(ch);
          } else {
            Character top = stack.peek();
            if (top == '(') {
              stack.pop();
            }
          }
        }
      }
      if(stack.isEmpty()) {
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }
    }
  }
}
