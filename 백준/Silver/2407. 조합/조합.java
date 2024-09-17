import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int top = Integer.parseInt(st.nextToken());
    int bottom = Integer.parseInt(st.nextToken());

    BigInteger totalTop = BigInteger.ONE;
    for (int i = 0; i < bottom; i++) {
      totalTop = totalTop.multiply(new BigInteger(String.valueOf(top-i)));
    }

    BigInteger totalBottom = BigInteger.ONE;
    for (int i = 1; i <= bottom; i++) {
      totalBottom = totalBottom.multiply(new BigInteger(String.valueOf(i)));
    }

    System.out.println(totalTop.divide(totalBottom));
  }
}
