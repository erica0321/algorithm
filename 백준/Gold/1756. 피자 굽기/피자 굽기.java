import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int D;
  public static int N;
  public static int[] oven;
  public static int[] pizza;
  public static int depth;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    D = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    oven = new int[D];
    pizza = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < D; i++) {
      oven[i] = Integer.parseInt(st.nextToken());
    }

    st= new StringTokenizer(br.readLine());
    for(int i = 0; i<N; i++) {
      pizza[i] = Integer.parseInt(st.nextToken());
    }

    // 오븐 들어가는 공간 재 조정
    for (int i = 1; i < D; i++) {
      oven[i] = Math.min(oven[i], oven[i - 1]);
    }

    depth = D;

    // 피자를 하나씩 오븐에 넣기
    for (int i = 0; i < N; i++) {
      if (depth == 0) {
        System.out.println(0);
        return;
      }
      depth = BSearch(pizza[i], depth);
      if (depth == -1) {
        System.out.println(0);
        return;
      }
    }

    System.out.println(depth + 1);

  }

  public static int BSearch(int num, int currentDepth) {
    int minIdx = 0; //제일큰 곳
    int maxIdx = currentDepth - 1; //제일 작은곳
    int answer = -1;

    while (minIdx <= maxIdx) {
      int midIdx = (minIdx + maxIdx) / 2;
      if (oven[midIdx] >= num) {
        answer = midIdx;
        minIdx = midIdx + 1;
      } else {
        maxIdx = midIdx - 1;
      }
    }
    return answer;
  }
}