import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] board;
  public static final int SIZE = 19;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int total = Integer.parseInt(br.readLine());

    board = new int[SIZE][SIZE];

    for (int i = 0; i < total; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      //홀수면 검정색: 1
      //짝수면 흰색: 2
      int player = (i % 2 == 0) ? 1 : 2;

      board[x][y] = player;

      if (isWinner(x, y, player)) {
        System.out.println(i + 1);
        return;
      }
    }

    System.out.println(-1); 

  }

  public static boolean isWinner(int x, int y, int player) {
    // 일열 찾기
    int [][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};

    for(int[] dir: directions) {
      int count = 1;

      count += countStones(x, y, dir[0], dir[1], player);
      count += countStones(x, y, -dir[0], -dir[1], player);

      if(count == 5) {
        return true;
      }
    }
    return false;
  }

  public static int countStones(int x, int y, int dirX, int dirY, int player) {
    int count = 0;
    int nx = x + dirX;
    int ny = y + dirY;

    while(nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
      count ++;
      nx += dirX;
      ny += dirY;
    }

    return count;
  }
}
