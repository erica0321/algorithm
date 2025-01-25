import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] alphabet = new int[26];
    String str = br.readLine().toUpperCase();

    for (int i = 0; i < str.length(); i++) {
      int tempNum = str.charAt(i) - 65;
      alphabet[tempNum]++;
    }
    
    int max = 0;
    char ch = '?';

    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] > max) {
        max = alphabet[i];
        ch = (char) (i + 65);
      } else if (alphabet[i] == max) {
        ch = '?';
      }
    }
    System.out.println(ch);
  }
}
