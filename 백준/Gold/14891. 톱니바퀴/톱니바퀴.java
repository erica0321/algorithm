import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int[][] data = new int[4][8];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i =0; i<4; i++) {
      String str = br.readLine();
      for(int j =0; j<str.length(); j++) {
        data[i][j] = (Integer.parseInt(String.valueOf(str.charAt(j))));
      }
    }

    int Test = Integer.parseInt(br.readLine());
    for(int i =0; i<Test; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int targetNum = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());

      start(targetNum, dir);
    }

    int total =0;
    if(data[0][0] == 1) total += 1;
    if(data[1][0] == 1) total += 2;
    if(data[2][0] == 1) total += 4;
    if(data[3][0] == 1) total += 8;

    System.out.println(total);
  }

  public static void start(int targetNum, int dir) {
    checkLeft(targetNum -1, -dir);
    checkRight(targetNum + 1, -dir);
    rotate(targetNum, dir);
  }

  public static void rotate(int targetNum, int dir) {
    if(dir==1) {
      int tmp = data[targetNum][7];
      for(int i=7; i>0; i--) {
        data[targetNum][i] = data[targetNum][i - 1];
      }
      data[targetNum][0] = tmp;
    }else {
      int tmp = data[targetNum][0];
      for(int i=0; i<7; i++) {
        data[targetNum][i] = data[targetNum][i + 1];
      }
      data[targetNum][7] = tmp;
    }
  }
  
  public static void checkLeft(int targetNum, int dir) {
    if (targetNum < 0) return;
    if (data[targetNum][2] == data[targetNum + 1][6]) return;
    checkLeft(targetNum - 1, -dir);
    rotate(targetNum, dir);
  }
  
  public static void checkRight(int targetNum, int dir) {
    if (targetNum > 3) return;
    if (data[targetNum - 1][2] == data[targetNum][6]) return;
    checkRight(targetNum + 1, -dir);
    rotate(targetNum, dir);
  }
}
