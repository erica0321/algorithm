import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] board = new int[8][8];
  public static int kingX;
  public static int kingY;
  public static int rockX;
  public static int rockY;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String king = st.nextToken();
    String rock = st.nextToken();
    int moveNum = Integer.parseInt(st.nextToken());

    kingX = king.charAt(0) - 'A';
    kingY = king.charAt(1) - '1';
    rockX = rock.charAt(0) - 'A';
    rockY = rock.charAt(1) - '1';

    //이동방향
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    for(int i = 0; i < moveNum; i++) {
      String dir = br.readLine();

      switch(dir) {
        case "R":
          isMove(dx[0], dy[0]);
          break;
        case "L":
          isMove(dx[1], dy[1]);
          break;
        case "B":
          isMove(dx[2], dy[2]);
          break;
        case "T":
          isMove(dx[3], dy[3]);
          break;
        case "RT":
          isMove(dx[4], dy[4]);
          break;
        case "LT":
          isMove(dx[5], dy[5]);
          break;
        case "RB":
          isMove(dx[6], dy[6]);
          break;
        case "LB":
          isMove(dx[7], dy[7]);
          break;
      }
    }

    // 최종 결과 출력
    String endKing = "" + (char)(kingX + 'A') + (char)(kingY + '1');
    String endRock = "" + (char)(rockX + 'A') + (char)(rockY + '1');

    System.out.println(endKing);
    System.out.println(endRock);
  }

  public static void isMove(int dx, int dy) {
    int nx = kingX + dx;
    int ny = kingY + dy;

    if(nx < 0 || nx > 7 || ny < 0 || ny > 7) {
      return;
    }

    if(nx == rockX && ny == rockY) {
      int nRockX = rockX + dx;
      int nRockY = rockY + dy;

      if(nRockX < 0 || nRockX > 7 || nRockY < 0 || nRockY > 7) {
        return;
      }

      rockX = nRockX;
      rockY = nRockY;
    }

    kingX = nx;
    kingY = ny;
  }
}
