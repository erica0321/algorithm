import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    for(int i =0; i<tc; i++) {
      String func = br.readLine();
      Deque<Integer> deque = new LinkedList<>();
      br.readLine();
      String arrStr = br.readLine();
      for (String s : arrStr.substring(1, arrStr.length() - 1).split(","))
        if (!s.isEmpty())
          deque.add(Integer.valueOf(s));

      calc(deque, func);
    }

  }

  public static void calc(Deque<Integer> deque, String func) {
    boolean reverse = false;

    for (char command : func.toCharArray()) {
      if (command == 'R')
        reverse = !reverse;
      else {
        if (deque.isEmpty()) {
          System.out.println("error");
          return;
        }
        if (reverse) deque.removeLast();
        else deque.removeFirst();
      }
    }

    StringBuilder sb = new StringBuilder("[");
    while (!deque.isEmpty()) {
      sb.append(reverse ? deque.removeLast() : deque.removeFirst());
      if (!deque.isEmpty())
        sb.append(',');
    }
    sb.append(']');

    System.out.println( sb.toString());
  }
}
