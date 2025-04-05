import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] tri = new int[n][2];

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      tri[i][0] = Integer.parseInt(st.nextToken());
      tri[i][1] = Integer.parseInt(st.nextToken());
    }

    double area = 0;
    for(int i = 0; i < n-2; i++) {
      for(int j = i+1; j < n-1; j++) {
        for(int k = j+1; k < n; k++) {
          area = Math.max(area, getArea(tri[i], tri[j], tri[k]));
        }
      }

    }
    System.out.println(area);
  }

  public static double getArea(int[] num1, int[] num2, int[] num3) {
    return (double) Math.abs(num1[0] * num2[1] + num2[0] * num3[1] + num3[0] * num1[1] - num1[1] * num2[0] - num2[1] * num3[0] - num3[1] * num1[0]) / 2;
  }
}