import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0; i<str.length(); i++) {
            stack.offerLast(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        boolean stop  = true;
        while(stop) {
            if(stack.size() == 2) {
                stop = false;
            }
            char first = stack.pollFirst();
            char second = stack.pollFirst();

            if(first == '(' && second == ')') {
                sb.append(first + "1");
            } else if(first == ')' && second == '(') {
                sb.append(first + "+");
            } else {
                sb.append(first);
            }
            stack.offerFirst(second);
			if (!stop) sb.append(second);
        }
        System.out.print(String.valueOf(sb));
    }
}
