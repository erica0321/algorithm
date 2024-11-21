import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      stack.push(c);

      if (stack.size() >= bomb.length() && c == bomb.charAt(bomb.length() - 1)) {
        boolean isBomb = true;
        for (int j = 0; j < bomb.length(); j++) {
          if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
            isBomb = false;
            break;
          }
        }
        if (isBomb) {
          for (int k = 0; k < bomb.length(); k++) {
            stack.pop();
          }
        }
      }
    }

    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      StringBuilder result = new StringBuilder();
      for (char c : stack) {
        result.append(c);
      }
      System.out.println(result);
    }
  }
}
