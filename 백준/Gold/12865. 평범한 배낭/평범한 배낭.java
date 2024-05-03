import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    int num = Integer.parseInt(input.split(" ")[0]);
    int weight = Integer.parseInt(input.split(" ")[1]);

    int[][] junseo = new int[num + 1][2];
    int[][] dp = new int[num + 1][weight + 1];

    for (int i = 1; i <= num; i++) {
      String input2 = scanner.nextLine();
      int w = Integer.parseInt(input2.split(" ")[0]);
      int v = Integer.parseInt(input2.split(" ")[1]);

      junseo[i][0] = w;
      junseo[i][1] = v;
    }

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= weight; j++) {
        if (junseo[i][0] > j) {
          dp[i][j] = dp[i - 1][j];
          continue;
        }

        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - junseo[i][0]] + junseo[i][1]);
      }
    }
    scanner.close();
    System.out.println(dp[num][weight]);
  }
}
