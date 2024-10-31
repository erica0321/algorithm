import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static int N, M, length;

  public static void main(String[] args) throws IOException {
    length = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
      length += arr[i].length();
    }

    int even = (M - length) / (N - 1);
    int left = (M - length) % (N - 1);
    String interval = "_".repeat(even);

    List<String> result = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      if (i == 0) {
        result.add(arr[i]);
        continue;
      }
      if (arr[i].charAt(0) >= 'a' && arr[i].charAt(0) <= 'z') {
        if (left > 0) {
          result.add(interval + "_");
          left--;
          result.add(arr[i]);
        } else {
          result.add(interval);
          result.add(arr[i]);
        }
      } else {
        result.add(interval);
        result.add(arr[i]);
      }
    }

    if (left > 0) {
      for (int i = result.size() - 1; i >= 0; i--) {
        if (result.get(i).charAt(0) >= 'A' && result.get(i).charAt(0) <= 'Z') {
          if (left > 0) {
            result.set(i, "_" + result.get(i));
            left--;
          }
        }
      }
    }

    System.out.println(String.join("", result));
  }
}
