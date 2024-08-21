import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int n = Integer.parseInt(str.split(" ")[0]);
    int m = Integer.parseInt(str.split(" ")[1]);

    int[] moneys = new int[n];

    int totalMoney = 0;
    int maxMoney = 0;

    for (int i = 0; i < n; i++) {
      int money = Integer.parseInt(br.readLine());
      moneys[i] = money;
      totalMoney += money;
      if (money > maxMoney) {
        maxMoney = money;
      }
    }

    int min = maxMoney;
    int max = totalMoney;

    while (min <= max) {
      int middle = (min + max) / 2;
      int sum = 0;
      int count = 1;

      for (int i = 0; i < n; i++) {
        if (sum + moneys[i] > middle) {
          count++;
          sum = 0;
        }
        sum += moneys[i];
      }

      if (count > m) {
        min = middle + 1;
      } else {
        max = middle - 1;
      }
    }

    System.out.println(min);
  }
}
