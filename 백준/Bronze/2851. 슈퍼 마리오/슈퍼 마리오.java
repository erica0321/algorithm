import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int closestSum = 0;

    for (int i = 0; i < 10; i++) {
      int num = Integer.parseInt(br.readLine());
      sum += num;

      if (Math.abs(sum - 100) <= Math.abs(closestSum - 100)) {
        closestSum = sum;
      }
    }

    System.out.println(closestSum);
  }
}
