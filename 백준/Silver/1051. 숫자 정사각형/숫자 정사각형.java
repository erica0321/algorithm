import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][M];

    for(int i = 0; i < N; i++) {
      arr[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray(); // 공백 기준으로 분리
    }

    int maxLength = 1;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        for(int k = j + 1; k < M; k++) {
          if (arr[i][j] == arr[i][k]) {
            int length = k - j;

            if (i + length < N && j + length < M &&
                arr[i][j] == arr[i + length][j] &&
                arr[i][j] == arr[i + length][k]) {
              maxLength = Math.max(maxLength, length + 1);
            }
          }
        }
      }
    }

    System.out.println(maxLength * maxLength);
  }
}
