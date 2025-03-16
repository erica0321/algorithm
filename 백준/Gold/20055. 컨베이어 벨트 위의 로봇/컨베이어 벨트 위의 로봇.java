import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int[] belt;
  static boolean[] isRobot;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 벨트 내구성
    belt = new int[2 * N];
    // 로봇 존재 여부
    isRobot = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2*N; i++) { 
      belt[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    while (!isEnd()) {
      beltCircle();
      robotCircle();
      isNotBeltZero();
      result++;
    }
    System.out.println(result);
  }

  // 1. 벨트 회전 && 로봇 이동
  static void beltCircle() {
    int last = belt[2*N - 1];
    for (int i = 2*N - 1; i > 0; i--) {
      belt[i] = belt[i - 1];
    }
    belt[0] = last;
    for (int i = N-1; i > 0; i--) {
      isRobot[i] = isRobot[i - 1];
    }
    isRobot[0] = false;
    isRobot[N - 1] = false;
  }

  // 2. 로봇만 이동
  static void robotCircle() {
    for (int i = N-1; i > 0; i--) {
      if (isRobot[i - 1] && !isRobot[i] && belt[i] > 0) { // 앞칸에 로봇이 있고 이동 가능하면
        isRobot[i] = true;
        isRobot[i - 1] = false;
        belt[i]--;
      }
    }
    if (isRobot[N - 1]) isRobot[N - 1] = false; // 다시 확인 후 제거
  }

  // 3. 로봇 올리기
  static void isNotBeltZero() {
    if (belt[0] > 0) {
      isRobot[0] = true;
      belt[0]--;
    }
  }

  // 4. 내구도가 0인 칸 개수 체크
  static boolean isEnd() {
    int count = 0;
    for (int i = 0; i < 2*N; i++) {
      if (belt[i] == 0) count++;
    }
    return count >= K;
  }
}
