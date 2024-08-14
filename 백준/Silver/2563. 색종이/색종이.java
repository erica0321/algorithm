import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int [][] paper = new int[100][100];

    for(int i = 0; i < n; i++) {
      String[] inputs = br.readLine().split(" "); 
      int a = Integer.parseInt(inputs[0]);
      int b = Integer.parseInt(inputs[1]); 

      for(int j = a; j < a + 10; j++) {
        for(int k = b; k < b + 10; k++) {
          paper[j][k] = 1;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (paper[i][j] == 1) {
          answer++;
        }
      }
    }

    System.out.println(answer);
  }
}
