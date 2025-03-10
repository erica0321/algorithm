import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    findPrime(0, 0);
  }

  public static void findPrime(int num, int count) {
    if(count == N && isPrime(num)) System.out.println(num);

    for(int i = 0; i<10; i++) {
      int temp = num * 10 + i;
      if(isPrime(temp)) findPrime(temp, count +1);
    }
  }

  public static boolean isPrime(int num) {
    if (num < 2) return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
