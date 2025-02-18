import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static Stack<Character> stack;
  public static void main(String[] args) throws IOException {
    stack = new Stack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st = br.readLine();
    int answer = 0;
    int result = 1;

    boolean isRight = true;
    for(int i =0; i<st.length(); i++){
      char cur = st.charAt(i);
      if(cur == '(') {
        stack.push(cur);
        result *= 2;
      }
      else if(cur == '[') {
        stack.push(cur);
        result *= 3;
      }
      else if(cur == ')') {
        if(stack.isEmpty() || stack.peek() != '(') {
          isRight = false;
          break;
        }
        if(st.charAt(i-1) == '(') answer += result;
        stack.pop();
        result /= 2;
      }
      else if(cur == ']') {
        if(stack.isEmpty() || stack.peek() != '[') {
          isRight = false;
          break;
        }
        if(st.charAt(i-1) == '[') answer += result;
        stack.pop();
        result /= 3;
      }
    }

    if(isRight && stack.isEmpty()) System.out.println(answer);
    else System.out.println(0);
  }
}
