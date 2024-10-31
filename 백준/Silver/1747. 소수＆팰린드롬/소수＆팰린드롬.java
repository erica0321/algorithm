import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    if (num == 1) {
      System.out.println(2);
      return;
    }
    for (int i = num; ; i++) {
      if (isPrime(i) && isPalindrome(i)) {
        System.out.println(i);
        return;
      }
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

  public static boolean isPalindrome(int num) {
    String str = String.valueOf(num);
    int len = str.length();
    for (int i = 0; i <= len / 2; i++) {
      if (str.charAt(i) != str.charAt(len - i - 1)) return false;
    }
    return true;
  }
}
